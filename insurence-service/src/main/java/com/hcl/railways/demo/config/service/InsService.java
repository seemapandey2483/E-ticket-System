
package com.hcl.railways.demo.config.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import com.hcl.railways.demo.entity.Insurence;
import com.hcl.railways.demo.model.InsurenceInfo;
import com.hcl.railways.demo.repo.InsurenceRepository;

@Service
public class InsService {

	@Autowired
	InsurenceRepository insurenceRepository;

	@Transactional(isolation = Isolation.SERIALIZABLE, readOnly = true)
	public InsurenceInfo getInsurenceById(long id) {
		Optional<Insurence> tutorialData = insurenceRepository.findById(id);
		InsurenceInfo insurenceInfo = new InsurenceInfo();
		BeanUtils.copyProperties(tutorialData.get(), insurenceInfo);
		return insurenceInfo;
	}

	@Transactional(isolation = Isolation.SERIALIZABLE, readOnly = false)
	public InsurenceInfo createInsurence(InsurenceInfo insurenceInfo) {
		Insurence insurence = new Insurence();
		BeanUtils.copyProperties(insurenceInfo, insurence);

		insurence = insurenceRepository.save(insurence);

		BeanUtils.copyProperties(insurence, insurenceInfo);
		return insurenceInfo;
	}

}
