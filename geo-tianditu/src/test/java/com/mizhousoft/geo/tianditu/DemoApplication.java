package com.mizhousoft.geo.tianditu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.mizhousoft.commons.restclient.service.RestClientService;
import com.mizhousoft.geo.DistrictSearchService;
import com.mizhousoft.geo.GEOCoderService;
import com.mizhousoft.geo.GEOProfile;
import com.mizhousoft.geo.tianditu.coder.TMapGEOCoderServiceImpl;
import com.mizhousoft.geo.tianditu.search.TMapDistrictSearchServiceImpl;

@ComponentScan("com.mizhousoft")
@SpringBootApplication
public class DemoApplication
{
	@Autowired
	private RestClientService restClientService;

	@Value("${geo.tianditu.app-key}")
	private String appKey;

	public static void main(String[] args)
	{
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public GEOProfile getGEOProfile()
	{
		GEOProfile profile = new GEOProfile();
		profile.setAppKey(appKey);

		return profile;
	}

	@Bean
	public GEOCoderService getGEOCoderService(GEOProfile profile)
	{
		TMapGEOCoderServiceImpl geoCoderService = new TMapGEOCoderServiceImpl();
		geoCoderService.setProfile(profile);
		geoCoderService.setRestClientService(restClientService);

		return geoCoderService;
	}

	@Bean
	public DistrictSearchService getDistrictSearchService(GEOProfile profile)
	{
		TMapDistrictSearchServiceImpl districtSearchService = new TMapDistrictSearchServiceImpl();
		districtSearchService.setProfile(profile);
		districtSearchService.setRestClientService(restClientService);

		return districtSearchService;
	}
}
