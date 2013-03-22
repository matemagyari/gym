package home.gym.integration.test.util;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CucumberService {

    private static ClassPathXmlApplicationContext ctx;

    static {
        String[] contextPaths = new String[] { "classpath:META-INF/applicationContext-gym-cucumber.xml" };
        ctx = new ClassPathXmlApplicationContext(contextPaths, true);
    }

    public static <T> T getBean(Class<T> clazz) {
        return ctx.getBean(clazz);        
    }
    
    public static Object getBean(String name) {
        return ctx.getBean(name);        
    }


}
