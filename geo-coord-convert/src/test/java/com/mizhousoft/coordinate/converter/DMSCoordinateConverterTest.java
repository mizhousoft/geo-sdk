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
}
