package com.sp.webservices.statsws.descriptive;

import java.util.Arrays;
import java.util.OptionalDouble;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sp.webservices.statsws.calculator.CountCalculator;
import com.sp.webservices.statsws.calculator.StatisticsCalculator;
import com.sp.webservices.statsws.model.*;

@Component
@Path("statistics/v1")
public class DescriptiveStatsController {

	@Autowired
	StatisticsCalculator meanCanculator;
	
	@Autowired
	CountCalculator counter;
	
	@GET
	@Path("/calculate")
	@Produces(MediaType.APPLICATION_JSON)
	public Stats mean(@QueryParam("values") String values) {
		//TODO validate input
		Stats stats = new Stats();
		String [] valueArr = StringUtils.split(values, ',');
		
		stats.setMean(meanCanculator.calculate(valueArr));
		
		stats.setSize(counter.count(valueArr));
		
		return stats;
	}
}