package com.sp.webservices.statsws.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.sp.webservices.statsws.descriptive.MeanFormulaController;

@Component
public class JerseyConfig extends ResourceConfig{

	public JerseyConfig() {
		register(MeanFormulaController.class);
	}
}
