package com.mizhousoft.coordinate.converter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.com.skywalker.coordinateconverter.DecimalDegreesCoordinates;

/**
 * DMSCoordinateConverter
 *
 * @version
 */
public class DMSCoordinateConverterTest
{
	@Test
	public void convertEN()
	{
		try
		{
			DecimalDegreesCoordinates dd = DMSCoordinateConverter.convertEN("116°23'28.841\"", "39°54'19.417\"");

			Assertions.assertEquals("39.9053936111 116.3913447222", dd.toString());
		}
		catch (CoordinateException e)
		{
			Assertions.fail(e);
		}
	}

	@Test
	public void convertEN2()
	{
		try
		{
			DecimalDegreesCoordinates dd = DMSCoordinateConverter.convertEN("114°16'", "41°05'");

			Assertions.assertEquals("41.0833333333 114.2666666667", dd.toString());
		}
		catch (CoordinateException e)
		{
			Assertions.fail(e);
		}
	}

	@Test
	public void convertEN3()
	{
		try
		{
			DecimalDegreesCoordinates dd = DMSCoordinateConverter.convertEN("113°", "43°22′");

			Assertions.assertEquals("43.0000000000 113.0000000000", dd.toString());
		}
		catch (CoordinateException e)
		{
			Assertions.fail(e);
		}
	}
}
