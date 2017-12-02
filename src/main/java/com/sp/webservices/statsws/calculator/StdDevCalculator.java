package com.sp.webservices.statsws.calculator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.OptionalDouble;

import org.springframework.stereotype.Component;

@Component
public class StdDevCalculator implements StatisticsCalculator{

	@Override
	public double calculate(String[] array) {
		OptionalDouble mean = Arrays.stream(array).mapToDouble( x-> Double.parseDouble(x)).average();
		if(mean.isPresent()) {
			final double avg = mean.getAsDouble();
			//find the sum of the squared mean diff.
			double squaredDev = Arrays.stream(array)
										.mapToDouble( x -> Double.parseDouble(x) )
										.map(x -> (x - avg))
										.map(x -> (x * x))
										.sum();
			
			//find the standard deviation
			double stdDev = Math.sqrt(squaredDev/array.length);
			
			BigDecimal bd = new BigDecimal(stdDev);
			return bd.setScale(2,  RoundingMode.HALF_UP).doubleValue();
		}
		else {
			return 0;
		}
		
	}
}
