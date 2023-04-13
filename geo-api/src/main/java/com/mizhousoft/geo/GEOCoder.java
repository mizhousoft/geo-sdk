package com.mizhousoft.geo;

import com.mizhousoft.geo.model.Address;
import com.mizhousoft.geo.model.Location;

/**
 * 地理编码接口
 *
 * @version
 */
public interface GEOCoder
{
	/**
	 * 地理编码查询
	 * 
	 * @param address
	 * @param city
	 * @return
	 * @throws GEOException
	 */
	Location geo(String address, String city) throws GEOException;

	/**
	 * 逆地理编码查询
	 * 
	 * @param lng
	 * @param lat
	 * @return
	 * @throws GEOException
	 */
	Address regeo(double lng, double lat) throws GEOException;
}
