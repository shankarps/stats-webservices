package com.sp.webservices.statsws.calculator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.OptionalDouble;

import org.springframework.stereotype.Component;

@Component
public class CountCalculator{

	public int count(String[] array) {
		return array.length;
		
	}
}
