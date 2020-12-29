
package com.hcl.railways.demo.config.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import com.hcl.railways.demo.entity.Train;
import com.hcl.railways.demo.model.TrainInfo;
import com.hcl.railways.demo.repo.StationRepository;
import com.hcl.railways.demo.repo.TrainRepository;

@Service
public class TrainService {

	String[] days = new String[] { "", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };

	@Autowired
	TrainRepository trainRepository;

	@Autowired
	StationRepository stationRepository;

	@Transactional(isolation = Isolation.SERIALIZABLE, readOnly = true)
	public List<TrainInfo> getAllTrain() {
		List<TrainInfo> trains = new ArrayList<TrainInfo>();
		trainRepository.findAll().forEach(s -> {
			TrainInfo trainInfo = new TrainInfo();
			BeanUtils.copyProperties(s,trainInfo);
			trains.add(trainInfo);
		});

		return trains;

	}

	public TrainInfo findTrain(Long sourceId, Long destId,
			String strDate) throws ParseException {
		Calendar c = Calendar.getInstance();
		Date date1 = new SimpleDateFormat("dd-MM-yyyy").parse(strDate);
		c.setTime(date1);
		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);

		Train train = trainRepository.findBySourceStationIdAndDestStationIdContainingAndNoOfDays(sourceId, destId,
				"%" + days[dayOfWeek] + "%");
		TrainInfo trainInfo = new TrainInfo();
		BeanUtils.copyProperties(train, trainInfo);
		return trainInfo;

	}

	
	@Transactional(isolation = Isolation.SERIALIZABLE, readOnly = false)
	public TrainInfo create(TrainInfo trainInfo) {
		Train train = new Train();
		BeanUtils.copyProperties(trainInfo, train);

		train = trainRepository.save(train);
		BeanUtils.copyProperties(train, trainInfo);
		return trainInfo;
	}

		
}
