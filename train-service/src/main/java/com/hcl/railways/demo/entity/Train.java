package com.hcl.railways.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="TrainInfo")
@Table(name="TrainInfo")
public class Train implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long trainNumber;
	@Column
	private String trainName;
	@Column
	private Long sourceStationId;
	@Column
	private Long destStationId;
	@Column
	private String noOfDays;
	@Column
	private int status;
	
	
	public Train() {
		
	}
	public Long getTrainNumber() {
		return trainNumber;
	}

	public void setTrainNumber(Long trainNumber) {
		this.trainNumber = trainNumber;
	}

	public String getTrainName() {
		return trainName;
	}

	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}

	public Long getSourceStationId() {
		return sourceStationId;
	}

	public void setSourceStationId(Long sourceStationId) {
		this.sourceStationId = sourceStationId;
	}

	public Long getDestStationId() {
		return destStationId;
	}

	public void setDestStationId(Long destStationId) {
		this.destStationId = destStationId;
	}

	public String getNoOfDays() {
		return noOfDays;
	}

	public void setNoOfDays(String noOfDays) {
		this.noOfDays = noOfDays;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	

}