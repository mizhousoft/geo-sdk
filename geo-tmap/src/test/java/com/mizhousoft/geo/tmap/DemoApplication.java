package com.mizhousoft.geo.tmap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.mizhousoft.geo.DistrictSearchService;
import com.mizhousoft.geo.GEOCoderService;
import com.mizhousoft.geo.GEOProfile;
import com.mizhousoft.geo.tmap.coder.TMapGEOCoderServiceImpl;
import com.mizhousoft.geo.tmap.search.TMapDistrictSearchServiceImpl;

@ComponentScan("com.mizhousoft")
@SpringBootApplication
public class DemoApplication
{
	@Value("${geo.tmap.app-key}")
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

		return geoCoderService;
	}

	@Bean
	public DistrictSearchService getDistrictSearchService(GEOProfile profile)
	{
		TMapDistrictSearchServiceImpl districtSearchService = new TMapDistrictSearchServiceImpl();
		districtSearchService.setProfile(profile);

		return districtSearchService;
	}
}
