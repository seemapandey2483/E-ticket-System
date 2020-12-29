
package com.hcl.railways.demo.controller;

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
import com.hcl.railways.demo.config.service.InsService;
import com.hcl.railways.demo.model.InsurenceInfo;

@RestController
@EnableFeignClients
@RibbonClient(name = "ins-service", configuration = RibbonConfiguration.class)
public class InsController {

	@Autowired
	InsService insService;

	@GetMapping("/getInsurenceById/{id}")
	public ResponseEntity<InsurenceInfo> getInsurenceById(@PathVariable("id") long id) {
		InsurenceInfo tutorialData = insService.getInsurenceById(id);
	
		return new ResponseEntity<>(tutorialData, HttpStatus.OK);

	}

	@PostMapping("/addInsurence")
	public ResponseEntity<InsurenceInfo> createInsurence(@RequestBody InsurenceInfo insurenceInfo) {
		try {

			InsurenceInfo InsurenceInfo = insService.createInsurence(insurenceInfo);
			return new ResponseEntity<>(InsurenceInfo, HttpStatus.CREATED);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
