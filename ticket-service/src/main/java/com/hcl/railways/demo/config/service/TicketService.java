package com.hcl.railways.demo.config.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hcl.railways.demo.entity.Ticket;
import com.hcl.railways.demo.message.MessageSender;
import com.hcl.railways.demo.model.TicketInfo;
import com.hcl.railways.demo.repo.TicketRepository;

@Service
public class TicketService {

	@Autowired
	TicketRepository ticketRepository;
	@Autowired
	MessageSender messageSender;
	
	@Transactional(isolation = Isolation.SERIALIZABLE, readOnly = true)
	public TicketInfo getTicketById(long id) {
		Optional<Ticket> tutorialData = ticketRepository.findById(id);
		TicketInfo ticketInfo = new TicketInfo();
		BeanUtils.copyProperties(tutorialData.get(), ticketInfo);
		return ticketInfo;
		
	}

	@Transactional(isolation = Isolation.SERIALIZABLE, readOnly = false)
	public TicketInfo createTicket(TicketInfo ticketInfo,String ticketStatus) throws InterruptedException, JsonProcessingException {
			Ticket ticket = new Ticket();
			BeanUtils.copyProperties(ticketInfo, ticket);
			ticket.setTicketStatus(ticketStatus);
			ticket = ticketRepository.save(ticket);
			BeanUtils.copyProperties(ticket, ticketInfo);
			messageSender.sendInsurenceEvent(ticketInfo);
			messageSender.sendPaymentEvent(ticketInfo);
			return ticketInfo;
			
	}
}