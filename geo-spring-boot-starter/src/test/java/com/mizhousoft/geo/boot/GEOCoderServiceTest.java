package com.mizhousoft.geo.boot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mizhousoft.commons.httpclient.unirest.UnirestLogInterceptor;
import com.mizhousoft.geo.GEOCoderService;
import com.mizhousoft.geo.GEOException;
import com.mizhousoft.geo.model.Address;

import kong.unirest.core.Unirest;

/**
 * GEOCoder Test
 *
 * @version
 */
@SpringBootTest(classes = DemoApplication.class)
public class GEOCoderServiceTest
{
	@Autowired
	private GEOCoderService geoCoder;

	@BeforeAll
	public static void init()
	{
		Unirest.config().interceptor(new UnirestLogInterceptor());
	}

	@Test
	public void regeo()
	{
		try
		{
			Address address = geoCoder.regeo(113.6561111111f, 26.8130555556f);

			Assertions.assertEquals(address.getAddrComponent().getProvince(), "湖南省");
		}
		catch (GEOException e)
		{
			Assertions.fail(e);
		}
	}
}
