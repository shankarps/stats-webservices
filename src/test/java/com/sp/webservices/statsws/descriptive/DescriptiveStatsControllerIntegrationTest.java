package com.sp.webservices.statsws.descriptive;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.*;

import com.sp.webservices.statsws.model.Stats;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class DescriptiveStatsControllerIntegrationTest {
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void desctritiveCalcTest() {
		Stats response = restTemplate.getForObject("/v1/calculate?values=1.5,2.5,3.5,4,5", Stats.class);
		System.out.println(response);
		
		assertNotNull(response);
		assertThat(response.getSize()).isEqualTo(5);
		assertThat(response.getMean()).isEqualTo(3.3);
		assertThat(response.getMedian()).isEqualTo(3.5);
		
	}

}
