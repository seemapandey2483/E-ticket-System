package com.hcl.railways.demo.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hcl.railways.demo.config.service.TicketService;
import com.hcl.railways.demo.constants.Constants;
import com.hcl.railways.demo.model.TicketInfo;

@Component
public class MessageReceiver {
	@Autowired
	TicketService ticketService;

	String tempMessage = "";

	@JmsListener(destination = "ticket")
	public void receiveQueue(String text) {
		try {
			if (text.startsWith(Constants.preFix) && !tempMessage.equalsIgnoreCase(text)) {
				saveData(text);
				tempMessage = text;
				Thread.sleep(2000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void saveData(String text) throws JsonProcessingException, InterruptedException {
		String strId = text.substring(Constants.preFix.length(), text.length());
		TicketInfo ticketInfo = ticketService.getTicketById(new Long(strId));
		ticketService.createTicket(ticketInfo, Constants.COMPLETED);
	}

}
