package com.zmx.ssm.mq.service;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;
/**
 * 消息生产业务类
 * @author zhangwenchao
 *
 */
@Service
public class ProducerService {
	
	@Resource
	private JmsTemplate jmsTemplate;  
	
	/**
	 * 发送消息      
	 * @param destination
	 * @param message
	 */
	public void sendMessage(Destination destination, final String message) {  
	        System.out.println("---------------生产者发送消息-----------------");  
	        System.out.println("---------------生产者发了一个消息：" + message);  
	        jmsTemplate.send(destination, new MessageCreator() {  
	            public Message createMessage(Session session) throws JMSException {  
	                return session.createTextMessage(message);  
	            }  
	        });  
	 }   


}
