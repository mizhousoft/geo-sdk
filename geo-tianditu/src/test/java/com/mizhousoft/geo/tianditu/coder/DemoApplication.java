package com.mizhousoft.geo.tianditu.coder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.mizhousoft.commons.restclient.service.RestClientService;
import com.mizhousoft.geo.GEOCoder;
import com.mizhousoft.geo.GEOProfile;

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
	public GEOCoder localeResolver()
	{
		GEOProfile profile = new GEOProfile();
		profile.setAppKey("");

		TiandituGEOCoder geoCoder = new TiandituGEOCoder();
		geoCoder.setProfile(profile);
		geoCoder.setRestClientService(restClientService);

		return geoCoder;
	}
}
