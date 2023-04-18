package com.mizhousoft.geo.tianditu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.mizhousoft.commons.restclient.service.RestClientService;
import com.mizhousoft.geo.GEOCoderService;
import com.mizhousoft.geo.GEOProfile;
import com.mizhousoft.geo.tianditu.coder.TMapGEOCoderImpl;

@ComponentScan("com.mizhousoft")
@SpringBootApplication
public class DemoApplication
{
	@Autowired
	private RestClientService restClientService;

	public static void main(String[] args)
	{
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public GEOCoderService localeResolver()
	{
		GEOProfile profile = new GEOProfile();
		profile.setAppKey("");

		TMapGEOCoderImpl geoCoderService = new TMapGEOCoderImpl();
		geoCoderService.setProfile(profile);
		geoCoderService.setRestClientService(restClientService);

		return geoCoderService;
	}
}
