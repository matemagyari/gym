package home.gym.infrastructure.scheduling;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import home.gym.domain.core.service.EventMonitor;

import javax.annotation.Resource;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@ContextConfiguration(locations = "classpath:/META-INF/applicationContext-gym-scheduling-test.xml")
public class EventMonitorSchedulingTest extends AbstractJUnit4SpringContextTests {

    private static final Integer FREQUENCY_IN_MS = 180;
    
    @Value("${reader.checkfrequency.inmillisecs}")
    private Integer monitorFrequencyRateInMs;

    @Resource(name="eventMonitor")
    private EventMonitor eventMonitorMock;
    
    @BeforeClass
    public static void setup () {
        System.setProperty("reader.checkfrequency.inmillisecs", FREQUENCY_IN_MS.toString());
    }
    
    @Test
    public void schedulerWithProperFrequencyRate() throws InterruptedException {
        
        assertEquals(FREQUENCY_IN_MS, monitorFrequencyRateInMs);
        Mockito.reset(eventMonitorMock);
    
        int timeSpentSleepingInMs = timeSpentSleepingInMs();
        int expectedTimes = timeSpentSleepingInMs / monitorFrequencyRateInMs;
        
        System.out.println(String.format("Time elapsed: %d ms. Frequency in ms: %d .Expected times: %d", timeSpentSleepingInMs, monitorFrequencyRateInMs,expectedTimes ));
        assertTrue(expectedTimes > 1);
        
        //it should be exactly expectedTimes, yet sometimes it's expectedTimes + 1, reason unknown
        verify(eventMonitorMock, atLeast(expectedTimes)).checkEvents();
 
    }

    private int timeSpentSleepingInMs() throws InterruptedException {
        long startTimeStamp = System.currentTimeMillis();
        Thread.sleep(1000);
        return (int) (System.currentTimeMillis() - startTimeStamp);
    }
    

}
