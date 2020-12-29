package com.hcl.railways.demo.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class InsurenceInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long passangerId;
	
	private Long ticketId;
	
	private int status;
	
	private Date createDate;

	private Long insurenceId;
	
	private Long insurenceAmount;
	
	private Long ticketAmount;

	public InsurenceInfo() {

	}

	public Long getInsurenceId() {
		return insurenceId;
	}

	public void setInsurenceId(Long insurenceId) {
		this.insurenceId = insurenceId;
	}

	public Long getInsurenceAmount() {
		return insurenceAmount;
	}
	public void setInsurenceAmount(Long insurenceAmount) {
		this.insurenceAmount = insurenceAmount;
	}

	public Long getTicketAmount() {
		return ticketAmount;
	}

	public void setTicketAmount(Long ticketAmount) {
		this.ticketAmount = ticketAmount;
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

	

	
}