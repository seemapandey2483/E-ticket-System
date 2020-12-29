
package com.hcl.railways.demo.config.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import com.hcl.railways.demo.entity.Payment;
import com.hcl.railways.demo.message.MessageSender;
import com.hcl.railways.demo.model.PaymentInfo;
import com.hcl.railways.demo.repo.PaymentRepository;

@Service
public class PaymentService {

	@Autowired
	PaymentRepository paymentRepository;

	@Autowired
	MessageSender messageSender;

	@Transactional(isolation = Isolation.SERIALIZABLE, readOnly = true)
	public PaymentInfo getPaymentById(long id) {
		Optional<Payment> tutorialData = paymentRepository.findById(id);
		PaymentInfo paymentInfo = new PaymentInfo();
		BeanUtils.copyProperties(tutorialData.get(), paymentInfo);
		return paymentInfo;
	}

	@Transactional(isolation = Isolation.SERIALIZABLE, readOnly = false)
	public PaymentInfo createPayment(PaymentInfo paymentInfo) throws InterruptedException {
		String preFix = "Approved:";
		Payment payment = new Payment();
		BeanUtils.copyProperties(paymentInfo, payment);
		payment = paymentRepository.save(payment);
		BeanUtils.copyProperties(payment, paymentInfo);
		messageSender.sendInsurenceEvent(preFix + paymentInfo.getTicketId());
		return paymentInfo;

	}

}
