package com.hcl.railways.demo.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;


@Component
public class StationInfo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Long stationId;
	private String stationName;
	public Long getStationId() {
		return stationId;
	}
	public void setStationId(Long stationId) {
		this.stationId = stationId;
	}
	public String getStationName() {
		return stationName;
	}
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
	
}
