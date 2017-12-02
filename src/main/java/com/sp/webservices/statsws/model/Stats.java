package com.sp.webservices.statsws.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"size","mean","median","mode"})
public class Stats {

	@JsonPropertyDescription("This is the average of the sample")
	private double mean;
	
	@JsonPropertyDescription("This is the size of the sample")
	private int size;
	private double median;
	private double stdDev;

	
	public double getMean() {
		return mean;
	}

	public void setMean(double mean) {
		this.mean = mean;
	}

	@JsonProperty("N")
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public double getMedian() {
		return median;
	}

	public void setMedian(double median) {
		this.median = median;
	}

	public double getStdDev() {
		return stdDev;
	}

	public void setStdDev(double stdDev) {
		this.stdDev = stdDev;
	}

	@Override
	public String toString() {
		return "Stats [mean=" + mean + ", size=" + size + ", median=" + median + ", stdDev=" + stdDev
				+ "]";
	}

}
