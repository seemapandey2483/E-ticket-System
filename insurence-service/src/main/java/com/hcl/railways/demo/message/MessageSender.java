package com.hcl.railways.demo.message;

import javax.jms.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;
import com.hcl.railways.demo.model.InsurenceInfo;


@Component
public class MessageSender {

	@Autowired
	private JmsMessagingTemplate jmsMessagingTemplate;

	@Autowired
	private Topic queue;
	public  void sendInsurenceEvent(InsurenceInfo insurenceInfo) throws InterruptedException {
		   Thread.sleep(1000);
		   this.jmsMessagingTemplate.convertAndSend(this.queue, insurenceInfo);
	}
}