package com.mizhousoft.geo.model;

/**
 * 位置
 *
 * @version
 */
public class Location
{
	/**
	 * 经度值
	 */
	private double lng;

	/**
	 * 纬度值
	 */
	private double lat;

	/**
	 * 类别名称
	 */
	private String level;

	/**
	 * 获取lng
	 * 
	 * @return
	 */
	public double getLng()
	{
		return lng;
	}

	/**
	 * 设置lng
	 * 
	 * @param lng
	 */
	public void setLng(double lng)
	{
		this.lng = lng;
	}

	/**
	 * 获取lat
	 * 
	 * @return
	 */
	public double getLat()
	{
		return lat;
	}

	/**
	 * 设置lat
	 * 
	 * @param lat
	 */
	public void setLat(double lat)
	{
		this.lat = lat;
	}

	/**
	 * 获取level
	 * 
	 * @return
	 */
	public String getLevel()
	{
		return level;
	}

	/**
	 * 设置level
	 * 
	 * @param level
	 */
	public void setLevel(String level)
	{
		this.level = level;
	}
}
