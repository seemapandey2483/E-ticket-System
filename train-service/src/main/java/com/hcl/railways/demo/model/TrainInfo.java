package com.hcl.railways.demo.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class TrainInfo implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long trainNumber;
	private String trainName;
	private Long sourceStationId;
	private Long destStationId;
	private String noOfDays;
	private int status;
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