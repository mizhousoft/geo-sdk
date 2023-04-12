package com.mizhousoft.geo;

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
	private float lng;

	/**
	 * 纬度值
	 */
	private float lat;

	/**
	 * 类别名称
	 */
	private String level;

	/**
	 * 获取lng
	 * 
	 * @return
	 */
	public float getLng()
	{
		return lng;
	}

	/**
	 * 设置lng
	 * 
	 * @param lng
	 */
	public void setLng(float lng)
	{
		this.lng = lng;
	}

	/**
	 * 获取lat
	 * 
	 * @return
	 */
	public float getLat()
	{
		return lat;
	}

	/**
	 * 设置lat
	 * 
	 * @param lat
	 */
	public void setLat(float lat)
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
