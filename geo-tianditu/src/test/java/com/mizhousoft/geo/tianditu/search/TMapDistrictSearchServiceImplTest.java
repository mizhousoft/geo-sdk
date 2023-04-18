package com.mizhousoft.geo.tianditu.search;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.mizhousoft.geo.DistrictSearchService;
import com.mizhousoft.geo.GEOException;
import com.mizhousoft.geo.tianditu.DemoApplication;

/**
 * TMapDistrictSearchServiceImplTest
 *
 * @version
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = DemoApplication.class)
public class TMapDistrictSearchServiceImplTest
{
	@Autowired
	private DistrictSearchService districtSearchService;

	@Test
	public void geo()
	{
		try
		{
			districtSearchService.search("中华人民共和国", 1, false);
		}
		catch (GEOException e)
		{
			Assertions.fail(e);
		}
	}
}
