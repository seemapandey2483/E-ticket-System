package com.hcl.railways.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.hcl.railways.demo.config.RibbonConfiguration;
import com.hcl.railways.demo.config.service.TicketService;
import com.hcl.railways.demo.constants.Constants;
import com.hcl.railways.demo.model.TicketInfo;

@RestController
@EnableFeignClients
@RibbonClient(name = "ticket-service", configuration = RibbonConfiguration.class)
public class TicketController {

	@Autowired
	TicketService ticketService;

	@GetMapping("/getTicketById/{id}")
	public ResponseEntity<TicketInfo> getTicketById(@PathVariable("id") long id) {
		TicketInfo tutorialData = ticketService.getTicketById(id);
		return new ResponseEntity<>(tutorialData, HttpStatus.OK);

	}

	@PostMapping("/bookTickets")
	public ResponseEntity<TicketInfo> createTicket(@RequestBody TicketInfo ticket) {
		try {
			TicketInfo ticketInfo = ticketService.createTicket(ticket, Constants.PENDING);
			return new ResponseEntity<>(ticketInfo, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}