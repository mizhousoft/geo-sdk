package com.mizhousoft.geo.tianditu.coder;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.mizhousoft.geo.GEOException;
import com.mizhousoft.geo.model.Address;
import com.mizhousoft.geo.model.Location;
import com.mizhousoft.geo.tianditu.DemoApplication;

/**
 * TiandituGEOCoder Test
 *
 * @version
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = DemoApplication.class)
public class TiandituGEOCoderTest
{
	@Autowired
	private TiandituGEOCoder geoCoder;

	@Test
	public void geo()
	{
		try
		{
			Location location = geoCoder.geo("株洲市茶陵县湖南龙华农牧发展有限公司东北约682米", null);

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
			Address address = geoCoder.regeo(113.6561111111f, 26.8130555556f);

			Assertions.assertEquals(address.getAddrComponent().getProvince(), "湖南省");
		}
		catch (GEOException e)
		{
			Assertions.fail(e);
		}
	}
}
