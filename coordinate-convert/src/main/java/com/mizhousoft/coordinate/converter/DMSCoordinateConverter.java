package com.mizhousoft.coordinate.converter;

import org.apache.commons.lang3.tuple.ImmutableTriple;
import org.apache.commons.lang3.tuple.Triple;

import br.com.skywalker.coordinateconverter.CoordinatesConverter;
import br.com.skywalker.coordinateconverter.Datums;
import br.com.skywalker.coordinateconverter.DecimalDegreesCoordinates;
import br.com.skywalker.coordinateconverter.DegreesMinutesSecondsCoordinates;
import br.com.skywalker.coordinateconverter.Location;

/**
 * 转换器
 *
 * @version
 */
public abstract class DMSCoordinateConverter
{
	public static DecimalDegreesCoordinates convert(Location lngLocation, String longitude, Location latLocation, String latitude,
	        Datums datums) throws CoordinateException
	{
		if (null == lngLocation || null == longitude || null == latLocation || null == latitude)
		{
			throw new CoordinateException("Funcation paramter is null.");
		}

		Triple<Long, Long, Double> lng = parseCoordinate(longitude);
		if (null == lng)
		{
			throw new CoordinateException(longitude + " is illegal.");
		}

		Triple<Long, Long, Double> lat = parseCoordinate(latitude);
		if (null == lat)
		{
			throw new CoordinateException(longitude + " is illegal.");
		}

		DegreesMinutesSecondsCoordinates degreesMinutesSecondsCoordinates = new DegreesMinutesSecondsCoordinates(latLocation, lat.getLeft(),
		        lat.getMiddle(), lat.getRight(), lngLocation, lng.getLeft(), lng.getMiddle(), lng.getRight(), datums);

		DecimalDegreesCoordinates dd = CoordinatesConverter.toDD(degreesMinutesSecondsCoordinates);

		return dd;
	}

	public static DecimalDegreesCoordinates convert(Location lngLocation, String longitude, Location latLocation, String latitude)
	        throws CoordinateException
	{
		return convert(lngLocation, longitude, latLocation, latitude, Datums.WGS84);
	}

	public static DecimalDegreesCoordinates convertES(String longitude, String latitude) throws CoordinateException
	{
		return convert(Location.EAST, longitude, Location.SOUTH, latitude, Datums.WGS84);
	}

	public static DecimalDegreesCoordinates convertEN(String longitude, String latitude) throws CoordinateException
	{
		return convert(Location.EAST, longitude, Location.NORTH, latitude, Datums.WGS84);
	}

	public static DecimalDegreesCoordinates convertWS(String longitude, String latitude) throws CoordinateException
	{
		return convert(Location.WEST, longitude, Location.SOUTH, latitude, Datums.WGS84);
	}

	public static DecimalDegreesCoordinates convertWN(String longitude, String latitude) throws CoordinateException
	{
		return convert(Location.WEST, longitude, Location.NORTH, latitude, Datums.WGS84);
	}

	public static Triple<Long, Long, Double> parseCoordinate(String coordinate)
	{
		int index1 = coordinate.indexOf("°");
		int index2 = coordinate.indexOf("'");
		int index3 = coordinate.indexOf("\"");

		if (-1 == index1 || -1 == index2 || -1 == index3)
		{
			return null;
		}

		long deg = Integer.valueOf(coordinate.substring(0, index1));
		long min = Integer.valueOf(coordinate.substring(index1 + 1, index2));
		double sec = Double.valueOf(coordinate.substring(index2 + 1, index3));

		return ImmutableTriple.of(deg, min, sec);
	}
}
