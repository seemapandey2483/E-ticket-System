package com.hcl.railways.demo.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class PaymentInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	
	
	private Long passangerId;
	
	private Long ticketId;
	
	private Long ticketPrice;
	
	private int status;
	
	private Date createDate;
	
		
	private Long amount;
	
    private int paymentId;
	
	public PaymentInfo() {

	}

	public Long getPassangerId() {
		return passangerId;
	}

	public void setPassangerId(Long passangerId) {
		this.passangerId = passangerId;
	}

	public Long getTicketId() {
		return ticketId;
	}

	public void setTicketId(Long ticketId) {
		this.ticketId = ticketId;
	}

	public Long getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(Long ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	

	

	public Long getAmount() {
		return amount;
	}


	public void setAmount(Long amount) {
		this.amount = amount;
	}


	public int getPaymentId() {
		return paymentId;
	}


	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	
}