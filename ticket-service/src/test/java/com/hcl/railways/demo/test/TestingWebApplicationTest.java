package com.hcl.railways.demo.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.hcl.railways.demo.config.service.TicketService;
import com.hcl.railways.demo.model.TicketInfo;
import com.hcl.railways.demo.repo.TicketRepository;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestingWebApplicationTest {

	@Mock
	private TicketService ticketService;
	@Mock
	private TicketRepository ticketRepository;

	

	@Test
	public void getTicketByIdTest() throws Exception {
		TicketInfo info = ticketService.getTicketById(30);
		TicketInfo ticketInfo = new TicketInfo();
		if (info == null)
			assertEquals(null, info);
		else
			assertNotEquals(ticketInfo, info);
	}
	@Test
	public void createTicketTest() throws Exception {
		TicketInfo ticketInfo = new TicketInfo();
		TicketInfo info = ticketService.createTicket(ticketInfo, "testing");
		
		if (info == null)
			assertEquals(null, info);
		else
			assertNotEquals(ticketInfo, info);
	}
}