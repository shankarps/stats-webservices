package com.sp.webservices.statsws.calculator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.OptionalDouble;

import org.springframework.stereotype.Component;

@Component
public class MeanCalculator implements StatisticsCalculator{

	@Override
	public double calculate(String[] array) {
		OptionalDouble mean = Arrays.stream(array).mapToDouble( x-> Double.parseDouble(x)).average();
		if(mean.isPresent()) {
			BigDecimal bd = new BigDecimal(mean.getAsDouble());
			return bd.setScale(2,  RoundingMode.HALF_UP).doubleValue();
		}
		else {
			return 0;
		}
		
	}
}
