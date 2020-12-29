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
import com.hcl.railways.demo.config.service.PaymentService;
import com.hcl.railways.demo.model.PaymentInfo;

@RestController
@EnableFeignClients
@RibbonClient(name = "payment-service", configuration = RibbonConfiguration.class)
public class PaymentController {

	@Autowired
	PaymentService paymentService;

	@GetMapping("/getPaymentById/{id}")
	public ResponseEntity<PaymentInfo> getPaymentById(@PathVariable("id") long id) {
		PaymentInfo tutorialData = paymentService.getPaymentById(id);

		return new ResponseEntity<>(tutorialData, HttpStatus.OK);

	}

	@PostMapping("/madePayment")
	public ResponseEntity<PaymentInfo> createPayment(@RequestBody PaymentInfo paymentInfo) {
		try {
			PaymentInfo PaymentInfo = paymentService.createPayment(paymentInfo);
			return new ResponseEntity<>(PaymentInfo, HttpStatus.CREATED);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
