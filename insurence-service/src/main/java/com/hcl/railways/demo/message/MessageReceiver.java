package com.hcl.railways.demo.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.railways.demo.config.service.InsService;
import com.hcl.railways.demo.model.InsurenceInfo;
import com.hcl.railways.demo.model.TicketInfo;

@Component
public class MessageReceiver {
	@Autowired
	InsService insService;
	
	@JmsListener(destination = "ins")
	public void receiveQueue(String text) {
		try {
			TicketInfo  ticketInfo = new ObjectMapper().readValue(text, TicketInfo.class);  
		  	InsurenceInfo insurenceInfo = new InsurenceInfo();
			insurenceInfo.setPassangerId(ticketInfo.getPassangerId());
			insurenceInfo.setInsurenceAmount(100l);
			insurenceInfo.setTicketAmount(ticketInfo.getTicketPrice());
			insurenceInfo.setStatus(ticketInfo.getStatus());
			insurenceInfo.setTicketId(ticketInfo.getTicketId());
			insurenceInfo = insService.createInsurence(insurenceInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

		
	
}
