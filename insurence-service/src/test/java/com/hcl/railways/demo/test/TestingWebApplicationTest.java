package com.hcl.railways.demo.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.hcl.railways.demo.config.service.InsService;
import com.hcl.railways.demo.model.InsurenceInfo;
import com.hcl.railways.demo.repo.InsurenceRepository;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestingWebApplicationTest {

	@Mock
	private InsService insService;
	@Mock
	private InsurenceRepository insurenceRepository;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getInsurenceByIdTest() throws Exception {
		InsurenceInfo info = insService.getInsurenceById(20l);
		InsurenceInfo insurenceInfo = new InsurenceInfo();
		if (info == null)
			assertEquals(null, info);
		else
			assertNotEquals(insurenceInfo, info);
	}

	@Test
	public void createTest() throws Exception {
		InsurenceInfo insurenceInfo = new InsurenceInfo();
		insurenceInfo.setInsurenceId(11l);
		InsurenceInfo info = insService.createInsurence(insurenceInfo);

		if (info == null)
			assertEquals(null, info);
		else
			assertNotEquals(insurenceInfo, info);
	}
}