package com.hcl.railways.demo.message;
import javax.jms.Topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.railways.demo.model.TicketInfo;

@Component
public class MessageSender {

	@Autowired
	private JmsMessagingTemplate jmsMessagingTemplate;

	@Autowired
	private Topic queue;
	@Autowired
	private Topic queuep;
	
	public  void sendInsurenceEvent(TicketInfo text) throws InterruptedException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
	     String jsonString = mapper.writeValueAsString(text);
		   this.jmsMessagingTemplate.convertAndSend(this.queue, jsonString);
	}
	
	public  void sendPaymentEvent(TicketInfo text) throws InterruptedException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
	     String jsonString = mapper.writeValueAsString(text);
		   this.jmsMessagingTemplate.convertAndSend(this.queuep, jsonString);
	}
}