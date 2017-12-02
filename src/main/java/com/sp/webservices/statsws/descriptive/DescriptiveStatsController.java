package com.sp.webservices.statsws.descriptive;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sp.webservices.statsws.calculator.CountCalculator;
import com.sp.webservices.statsws.calculator.MeanCalculator;
import com.sp.webservices.statsws.calculator.MedianCalculator;
import com.sp.webservices.statsws.calculator.StdDevCalculator;
import com.sp.webservices.statsws.model.Stats;

@Component
@Path("/v1")
public class DescriptiveStatsController {

	@Autowired
	MeanCalculator meanCanculator;
	
	@Autowired
	MedianCalculator medianCalculator;
	
	@Autowired
	CountCalculator counter;
	
	@Autowired
	StdDevCalculator stdCalculator;
	
	@GET
	@Path("/calculate")
	@Produces(MediaType.APPLICATION_JSON)
	public Stats mean(@QueryParam("values") String values) {
		//TODO validate input
		Stats stats = new Stats();
		String [] valueArr = StringUtils.split(values, ',');
		
		stats.setMean(meanCanculator.calculate(valueArr));
		
		stats.setSize(counter.count(valueArr));
		
		stats.setMedian(medianCalculator.calculate(valueArr));
		
		stats.setStdDev(stdCalculator.calculate(valueArr));
		
		return stats;
	}
}