
package com.hcl.railways.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.railways.demo.config.service.StationService;
import com.hcl.railways.demo.model.StationInfo;

@RestController
public class StationController {

	@Autowired
	StationService stationService;

	@GetMapping("/getAllstations")
	public ResponseEntity<List<StationInfo>> getAllSattion() {
		try {
			return new ResponseEntity<>(stationService.getAllSattion(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/addStations")
	public ResponseEntity<StationInfo> createStation(@RequestBody StationInfo stationInfo) {
		try {

			stationInfo = stationService.createStation(stationInfo);
			return new ResponseEntity<>(stationInfo, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
}
