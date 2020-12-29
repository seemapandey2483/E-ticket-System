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
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "TicketInfo")
@Table(name = "TicketInfo")
@Getter
@Setter
public class Ticket implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column
	private Long trainNumber;
	@Column
	private Long passangerId;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long ticketId;
	@Column
	private Long ticketPrice;
	@Column
	private int status;
	@Column
	private Date jurnyStartDate;
	@Column
	private Date ticketBookingDate;
	@Column
	private int NoOfTicket;
	@Column
	private String ticketStatus;
	
	public Ticket() {

	}

	public Long getTrainNumber() {
		return trainNumber;
	}

	public void setTrainNumber(Long trainNumber) {
		this.trainNumber = trainNumber;
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

	public Date getJurnyStartDate() {
		return jurnyStartDate;
	}

	public void setJurnyStartDate(Date jurnyStartDate) {
		this.jurnyStartDate = jurnyStartDate;
	}

	public Date getTicketBookingDate() {
		return ticketBookingDate;
	}

	public void setTicketBookingDate(Date ticketBookingDate) {
		this.ticketBookingDate = ticketBookingDate;
	}
	public int getNoOfTicket() {
		return NoOfTicket;
	}

	public void setNoOfTicket(int noOfTicket) {
		NoOfTicket = noOfTicket;
	}
	public String getTicketStatus() {
		return ticketStatus;
	}
	public void setTicketStatus(String ticketStatus) {
		this.ticketStatus = ticketStatus;
	}

}