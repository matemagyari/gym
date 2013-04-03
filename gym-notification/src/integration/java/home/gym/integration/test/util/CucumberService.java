package home.gym.integration.test.util;

import java.io.IOException;
import java.util.Properties;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

public class CucumberService {

    private static ClassPathXmlApplicationContext ctx;

    static {
        String[] contextPaths = new String[] { "classpath:META-INF/applicationContext-gym-basic-cucumber.xml" };
        ctx = new ClassPathXmlApplicationContext(contextPaths, true);
    }

    public static <T> T getBean(Class<T> clazz) {
        return ctx.getBean(clazz);        
    }
    
    public static Object getBean(String name) {
        return ctx.getBean(name);        
    }
    
    public static String getPropertyValue(String propertyName) {
        Resource resource = ctx.getResource("gym.properties");
        Properties properties = new Properties();
        try {
            properties.load(resource.getInputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties.getProperty(propertyName);
    }


}
