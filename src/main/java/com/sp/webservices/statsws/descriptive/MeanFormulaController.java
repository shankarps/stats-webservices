package com.sp.webservices.statsws.descriptive;

import java.util.Arrays;
import java.util.OptionalDouble;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
@Path("/v1/statistics")
public class MeanFormulaController {

	@GET
	@Path("/mean")
	public Double mean(@QueryParam("values") String values) {
		System.out.println(values);
		String [] valueArr = StringUtils.split(values, ',');
		OptionalDouble mean = Arrays.stream(valueArr).mapToDouble( x-> Double.parseDouble(x)).average();
		return mean.getAsDouble();
	}
}