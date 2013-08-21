package home.gym.infrastructure.persistence.repository;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.hssf.model.Sheet;
import org.apache.poi.hssf.model.Workbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class XlsConverter  {
    
    private static final int FILTER_ID = 2;
    private static final String NOT_SUPPORTED_TYPE = "NOT SUPPORTED TYPE";
    private static final int HEADER = 0;
    private static final int FILTER_TYPE = 1;
    private Workbook workbook;

    public XlsConverter(File file) throws IOException {
        FileInputStream inp = new FileInputStream(file);
        workbook = new XSSFWorkbook(inp);
    }
        
    public List<Mapper> convert() {
        List<Mapper> mappers = Lists.newArrayList();        
        
        Map<String, Filter> filtersMap = writeColumnsToMap(readSheetByName(workbook, "Filters"));       
        mappers.add(new FiltersMapper(filtersMap));
        
        Map<String, Category> categoriesToMap = writeCategoriesToMap(readSheetByName(workbook, "Category1"), filtersMap, 0);
        mappers.add(new CategoriesMapper(categoriesToMap));
        
        categoriesToMap = writeCategoriesToMap(readSheetByName(workbook, "Category2"), filtersMap, 1);
        mappers.add(new CategoriesMapper(categoriesToMap));
        
        categoriesToMap = writeCategoriesToMap(readSheetByName(workbook, "Category3"), filtersMap, 2);
        mappers.add(new CategoriesMapper(categoriesToMap));
        
        return mappers; 
    }
            
    private Map<String, Category> writeCategoriesToMap(Sheet sheet, Map<String, Filter> filters, int level) {
        Map<String, Category> rows = Maps.newHashMap();
        int selector = 0;
        for (Iterator<Row> rowsIt = sheet.rowIterator(); rowsIt.hasNext();) {           
            Row row = rowsIt.next();
            if (selector > 0) {
                Category category = new Category();
                category.setLevel(level);
                for (Iterator<Cell> cellsIt = row.cellIterator(); cellsIt.hasNext();) {
                    Cell cell = cellsIt.next(); 
                    String cellValue = getDataByCellType(cell);
                    setCategory(category, cellValue, CategoryIndex.values()[cell.getColumnIndex()], filters);                   
                }
                rows.put(category.getId(), category);
            }
            selector++;
        }
        return rows;
    }

    private Map<String, Filter> writeColumnsToMap(Sheet filterSheet) {
        Map<Integer, FilterData> ids = Maps.newHashMap();
        Map<String, Filter> columns = Maps.newHashMap();
        List<Filter> filterTypes = Lists.newArrayList();
        int selector = 0;
        for (Iterator<Row> rowsIt = filterSheet.rowIterator(); rowsIt.hasNext();) {
            Row row = rowsIt.next();
            for (Iterator<Cell> cellsIt = row.cellIterator(); cellsIt.hasNext();) {
                Cell cell = cellsIt.next();
                String cellValue = getDataByCellType(cell).trim();
                if (!cellValue.equals(NOT_SUPPORTED_TYPE)) {
                    if (selector == HEADER) {
                        if (cellValue.endsWith("ID")) {
                            ids.put(cell.getColumnIndex(), new FilterData(cellValue, new ArrayList<String>()));
                        } else {                        
                            columns.put(cellValue, new Filter(cell.getColumnIndex(), cellValue));
                        }
                    } else if (selector == FILTER_TYPE && cellValue != null) {
                        for (Filter f : columns.values()) {
                            if (f.getIndex() == cell.getColumnIndex()) {
                                f.setType(cellValue);
                                filterTypes.add(f);
                            }
                        }
                    } else {
                        if (ids.containsKey(cell.getColumnIndex())) {
                            FilterData filterData = ids.get(cell.getColumnIndex());
                            filterData.addFilterId(cellValue);
                        }
                        for (Filter f : columns.values()) {
                            if (!ids.containsKey(cell.getColumnIndex()) && f.getIndex() == cell.getColumnIndex()) {
                                f.addFilter(cellValue);
                                break;
                            }
                        }
                    }
                }
            }
            selector++;
        }
        for (FilterData fd : ids.values()) {
            String key = fd.getId().substring(0, fd.getId().length()-FILTER_ID);
            if (columns.containsKey(key)) {
                columns.get(key).setFiltersId(fd.getFilterIds());
            }
        }
        
        Collection<Filter> filters = columns.values();
        for (final Filter filterType : filterTypes) {
            for (Filter f : filters) {
                if (f.getName().toLowerCase().startsWith(filterType.getName().toLowerCase())) {
                    f.setType(filterType.getType());
                }
            }
        }
        
        return columns;
    }
    
    private Sheet readSheetByName(Workbook workbook, String name) {
        return workbook.getSheet(name);     
    }
    
    private void setCategory(Category category, String value, CategoryIndex categoryIndex, Map<String, Filter> filters) {
        switch (categoryIndex) {
        case ID:            
            category.setId(value);
            break;
        case NAME:
            category.setName(value);
            break;
        case FILTER:            
            category.setIndexedFilter(setFilterList(value, filters));
            break;
        case PARENT:            
            category.setParent(value);
            break;
        case DESCR:         
            category.setDescription(value);
            break;
        }
    }

    private List<Filter> setFilterList(String value, Map<String, Filter> filters) {
        String[] values = value.split(",");
        List<Filter> filterLists = Lists.newArrayList();        
        for (String filterName : values) {
            if (filterName.equals("NOT SUPPORTED TYPE")) {
                break;
            }
            if (filters.containsKey(filterName.trim())) {
                filterLists.add(filters.get(filterName.trim()));
            }
        }       
        return filterLists;
    }
    
    private String getDataByCellType(Cell cell) {
        String cellValue = "";
        switch (cell.getCellType()) {
        case Cell.CELL_TYPE_STRING:
            cellValue = cell.getRichStringCellValue().getString();
            break;
        case Cell.CELL_TYPE_NUMERIC:
            if (org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(cell)) {
                cellValue = cell.getDateCellValue().toString();
            } else {
                cellValue = String.valueOf(cell.getNumericCellValue());
            }
            break;
        case Cell.CELL_TYPE_BOOLEAN:
            cellValue = String.valueOf(cell.getBooleanCellValue());
            break;
        case Cell.CELL_TYPE_FORMULA:
            cellValue = cell.getCellFormula();
            break;
        default:
            cellValue = NOT_SUPPORTED_TYPE;
        }
        return cellValue;
    }


}