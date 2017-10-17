package test.com.zmx.ssm.mq;

import javax.annotation.Resource;
import javax.jms.Destination;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zmx.ssm.mq.service.ProducerService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class ProducerConsumerTest {
	
	    @Resource 
	    private ProducerService producerService; 
	    
	    @Resource(name="queueDestination")  
	    private Destination destination; 
	    
	    @Resource(name="sessionAwareQueue") 
	    private Destination sessionAwareQueue; 
	      
	    @Test  
	    public void testSend() {  
	        for (int i=0; i<2; i++) {  
	            producerService.sendMessage(destination, "你好，生产者！这是消息：" + (i+1));  
	        }  
	    } 
	    
	    
	    @Test  
	    public void testSessionAwareMessageListener() {  
	           producerService.sendMessage(sessionAwareQueue, "测试SessionAwareMessageListener");  
	    } 



}
