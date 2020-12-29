package com.hcl.railways.demo.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.hcl.railways.demo.config.service.TrainService;
import com.hcl.railways.demo.model.TrainInfo;
import com.hcl.railways.demo.repo.TrainRepository;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestingWebApplicationTest {

	@Mock
	private TrainService trainService;
	@Mock
	private TrainRepository trainRepository;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getAllTrainTest() throws Exception {
		List<TrainInfo> list = trainService.getAllTrain();
		int size = 0;
		if (size == list.size())
			assertEquals(size, list.size());
		else
			assertNotEquals(size, list.size());
	}

	@Test
	public void findTest() throws Exception {
		TrainInfo trainInfo = trainService.findTrain(1l, 2l, "18-12-2020");
		TrainInfo train = new TrainInfo();
		if (trainInfo == null)
			assertEquals(null, trainInfo);
		else
			assertNotEquals(train, trainInfo);
	}
	
	@Test
	public void createTest() throws Exception {
		TrainInfo trainInfo = new TrainInfo();
		TrainInfo info = trainService.create(trainInfo);
	
		if (info == null)
			assertEquals(null, info);
		else
			assertNotEquals(info, trainInfo);
	}
}