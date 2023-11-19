package com.mizhousoft.geo.tmap.coder;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.mizhousoft.commons.httpclient.unirest.UnirestLogInterceptor;
import com.mizhousoft.geo.GEOCoderService;
import com.mizhousoft.geo.GEOException;
import com.mizhousoft.geo.model.Address;
import com.mizhousoft.geo.model.Location;
import com.mizhousoft.geo.tmap.DemoApplication;

import kong.unirest.core.Unirest;

/**
 * TiandituGEOCoder Test
 *
 * @version
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = DemoApplication.class)
public class TMapGEOCoderImplTest
{
	@Autowired
	private GEOCoderService geoCoderService;

	@BeforeAll
	public static void init()
	{
		Unirest.config().interceptor(new UnirestLogInterceptor());
	}

	@Test
	public void geo()
	{
		try
		{
			Location location = geoCoderService.geo("济源市", null);

			Assertions.assertNotNull(location);
		}
		catch (GEOException e)
		{
			Assertions.fail(e);
		}
	}

	@Test
	public void regeo()
	{
		try
		{
			Address address = geoCoderService.regeo(112.597759f, 35.068343f);

			Assertions.assertEquals(address.getAddrComponent().getProvince(), "河南省");
		}
		catch (GEOException e)
		{
			Assertions.fail(e);
		}
	}
}
