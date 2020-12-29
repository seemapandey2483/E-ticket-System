package com.hcl.railways.demo.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity(name = "PaymentInfo")
@Table(name = "PaymentInfo")
@Getter
@Setter
public class Payment implements Serializable {
	private static final long serialVersionUID = 1L;

	
	@Column
	private Long passangerId;
	@Column
	private Long ticketId;
	@Column
	private Long ticketPrice;
	@Column
	private int status;
	@Column
	private Date createDate;
	
	@Column
	private Long amount;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private int paymentId;
	
	public Payment() {

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