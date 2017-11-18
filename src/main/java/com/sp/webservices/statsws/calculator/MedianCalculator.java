package com.sp.webservices.statsws.calculator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

import org.springframework.stereotype.Component;

@Component
public class MedianCalculator implements StatisticsCalculator {

	@Override
	public double calculate(String[] array) {
		//sort the elements into an array 
		double[] sorted = Arrays.stream(array)
									 .mapToDouble( x-> Double.parseDouble(x))
									 .sorted().toArray();
		
		//get median
		double median = 0;
		
		int len = sorted.length;
		
		//if even number of elements
		if(len %2 == 0) {
			median = (sorted[(len/2)-1] + sorted[len/2])/2;
		}else {
			median = sorted[len/2];
		}
		BigDecimal bd = new BigDecimal(median);
		return bd.setScale(2,  RoundingMode.HALF_UP).doubleValue();
	}

}
