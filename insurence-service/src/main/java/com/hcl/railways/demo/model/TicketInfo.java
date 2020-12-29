package com.hcl.railways.demo.model;

import java.io.Serializable;
import java.util.Date;
import org.springframework.stereotype.Component;

@Component
public class TicketInfo  implements Serializable{

private static final long serialVersionUID = -295422703255886286L;
	
	private Long trainNumber;
	private Long passangerId;
	private Long ticketId;
	private Long ticketPrice;
	private int status;
	private Date jurnyStartDate;
	private Date ticketBookingDate;
	private int NoOfTicket;
	private String ticketStatus;
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