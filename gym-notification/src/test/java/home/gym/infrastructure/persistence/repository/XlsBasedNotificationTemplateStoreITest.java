package home.gym.infrastructure.persistence.repository;

import static org.junit.Assert.assertFalse;
import home.gym.domain.core.model.templates.NotificationMessageTemplate;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-gym.xml")
public class XlsBasedNotificationTemplateStoreITest  {

    
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
