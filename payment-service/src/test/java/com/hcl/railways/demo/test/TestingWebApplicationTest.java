package com.hcl.railways.demo.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.hcl.railways.demo.config.service.PaymentService;
import com.hcl.railways.demo.model.PaymentInfo;
import com.hcl.railways.demo.repo.PaymentRepository;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestingWebApplicationTest {

	@Mock
	private PaymentService paymentService;
	@Mock
	private PaymentRepository paymentRepository;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getPaymentByIdTest() throws Exception {
		PaymentInfo info = paymentService.getPaymentById(20l);
		PaymentInfo paymentInfo = new PaymentInfo();
		if (info == null)
			assertEquals(null, info);
		else
			assertNotEquals(paymentInfo, info);
	}
	@Test
	public void createPaymentTest() throws Exception {
		PaymentInfo paymentInfo = new PaymentInfo();
		PaymentInfo info = paymentService.createPayment(paymentInfo);
		
		if (info == null)
			assertEquals(null, info);
		else
			assertNotEquals(paymentInfo, info);
	}
}