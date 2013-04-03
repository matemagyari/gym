package home.gym.infrastructure.persistence.repository;

import static org.junit.Assert.assertFalse;
import home.gym.domain.model.templates.NotificationMessageTemplate;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@ContextConfiguration(locations = "classpath:applicationContext-gym.xml")
public class XlsBasedNotificationTemplateStoreITest extends AbstractJUnit4SpringContextTests {

    
    @Resource
    private XlsBasedNotificationTemplateStore testObj;
    
    @Test
    public void readAll() {
        
        //act
        List<NotificationMessageTemplate> templates = testObj.readAll();
        //assert
        assertFalse(templates.isEmpty());
    }

}
