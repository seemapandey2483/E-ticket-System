
package com.hcl.railways.demo.config.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import com.hcl.railways.demo.entity.Station;
import com.hcl.railways.demo.model.StationInfo;
import com.hcl.railways.demo.repo.StationRepository;

@Service
public class StationService {

	@Autowired
	StationRepository stationRepository;

	@Transactional(isolation = Isolation.SERIALIZABLE, readOnly = true)
	public List<StationInfo> getAllSattion() {

		List<StationInfo> stations = new ArrayList<StationInfo>();
		stationRepository.findAll().forEach(s -> {
			StationInfo stationInfo = new StationInfo();
			BeanUtils.copyProperties(s,stationInfo);
			stations.add(stationInfo);
		});
		return stations;

	}

	@Transactional(isolation = Isolation.SERIALIZABLE, readOnly = false)
	public StationInfo createStation(StationInfo stationInfo) {
		Station station = new Station();
		BeanUtils.copyProperties(stationInfo, station);
		station = stationRepository.save(station);
		BeanUtils.copyProperties(station, stationInfo);
		return stationInfo;
	}

	@Transactional(isolation = Isolation.SERIALIZABLE, readOnly = false)
	public List<StationInfo> findByStationNameIn(List<String> ids) {
		List<StationInfo> stations = new ArrayList<StationInfo>();
		stationRepository.findByStationNameIn(ids).forEach(s -> {
			StationInfo stationInfo = new StationInfo();
			BeanUtils.copyProperties(s,stationInfo);
			stations.add(stationInfo);
		});
		return stations;
	}

}
