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

@Entity(name = "InsurenceInfo")
@Table(name = "InsurenceInfo")
@Getter
@Setter
 
public class Insurence implements Serializable {
	private static final long serialVersionUID = 1L;
	@Column
	private Long passangerId;
	@Column
	private Long ticketId;
	@Column
	private int status;
	@Column
	private Date createDate;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long insId;
	@Column
	private Long insurenceAmount;
	@Column
	private Long ticketAmount;

	public Insurence() {

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




	public void setInsId(Long insId) {
		this.insId = insId;
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