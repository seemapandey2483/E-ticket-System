
package com.hcl.railways.demo.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.hcl.railways.demo.config.RibbonConfiguration;
import com.hcl.railways.demo.config.service.StationService;
import com.hcl.railways.demo.config.service.TrainService;
import com.hcl.railways.demo.model.StationInfo;
import com.hcl.railways.demo.model.TrainInfo;

@RestController
@EnableFeignClients
@RibbonClient(name = "train-service", configuration = RibbonConfiguration.class)
public class TrainController {

	@Autowired
	TrainService trainService;

	@Autowired
	StationService stationService;

	@GetMapping("/getAlltrains")
	public ResponseEntity<List<TrainInfo>> getAllTrain() {
		return new ResponseEntity<>(trainService.getAllTrain(), HttpStatus.OK);
	}

	@GetMapping("/trainByFromAndTo/from/{from}/to/{to}/bookingDate/{bookingDate}")
	public ResponseEntity<TrainInfo> findTrain(@PathVariable("from") String from, @PathVariable("to") String to,
			@PathVariable("bookingDate") String bookingDate) throws ParseException {
		TrainInfo trainInfo = new TrainInfo();
		List<String> ids = new ArrayList<String>();
		ids.add(from);
		ids.add(to);
		List<StationInfo> list = stationService.findByStationNameIn(ids);
		if (!list.isEmpty()) {
			Long sourceId =new Long( list.get(0).getStationId());
			Long destId = new Long(list.get(1).getStationId());

			trainInfo = trainService.findTrain(sourceId, destId, bookingDate);

		}
		return new ResponseEntity<>(trainInfo, HttpStatus.OK);

	}

	@PostMapping("/addTrains")
	public ResponseEntity<TrainInfo> createTrain(@RequestBody TrainInfo train) {
		try {
			TrainInfo trainInfo = trainService.create(train);
			return new ResponseEntity<>(trainInfo, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
