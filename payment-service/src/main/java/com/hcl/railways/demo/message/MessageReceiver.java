package com.hcl.railways.demo.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.railways.demo.config.service.PaymentService;
import com.hcl.railways.demo.model.PaymentInfo;
import com.hcl.railways.demo.model.TicketInfo;

@Component
public class MessageReceiver {

	@Autowired
	PaymentService paymentService;

	@JmsListener(destination = "payment")
	public void receiveQueue(String text) {
		try {
			TicketInfo  ticketInfo = new ObjectMapper().readValue(text, TicketInfo.class);  
			PaymentInfo paymentInfo = new PaymentInfo();
			paymentInfo.setAmount(100l);
			paymentInfo.setPassangerId(ticketInfo.getPassangerId());
			paymentInfo.setStatus(ticketInfo.getStatus());
			paymentInfo.setTicketId(ticketInfo.getTicketId());
			paymentInfo.setTicketPrice(ticketInfo.getTicketPrice());
			paymentService.createPayment(paymentInfo);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
