package com.mizhousoft.geo.tianditu.excel;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * AreaRowData
 *
 * @version
 */
public class AreaRowData extends ExcelRowData
{
	// 省name
	@ExcelProperty(index = 1)
	private String provName;

	// 省gb
	@ExcelProperty(index = 2)
	private long provCode;

	// 市name
	@ExcelProperty(index = 3)
	private String cityName;

	// 市gb
	@ExcelProperty(index = 4)
	private long cityCode;

	// 县name
	@ExcelProperty(index = 5)
	private String county;

	// 县gb
	@ExcelProperty(index = 6)
	private long countyCode;

	/**
	 * 获取provName
	 * @return
	 */
	public String getProvName()
	{
		return provName;
	}

	/**
	 * 设置provName
	 * @param provName
	 */
	public void setProvName(String provName)
	{
		this.provName = provName;
	}

	/**
	 * 获取provCode
	 * @return
	 */
	public long getProvCode()
	{
		return provCode;
	}

	/**
	 * 设置provCode
	 * @param provCode
	 */
	public void setProvCode(long provCode)
	{
		this.provCode = provCode;
	}

	/**
	 * 获取cityName
	 * @return
	 */
	public String getCityName()
	{
		return cityName;
	}

	/**
	 * 设置cityName
	 * @param cityName
	 */
	public void setCityName(String cityName)
	{
		this.cityName = cityName;
	}

	/**
	 * 获取cityCode
	 * @return
	 */
	public long getCityCode()
	{
		return cityCode;
	}

	/**
	 * 设置cityCode
	 * @param cityCode
	 */
	public void setCityCode(long cityCode)
	{
		this.cityCode = cityCode;
	}

	/**
	 * 获取county
	 * @return
	 */
	public String getCounty()
	{
		return county;
	}

	/**
	 * 设置county
	 * @param county
	 */
	public void setCounty(String county)
	{
		this.county = county;
	}

	/**
	 * 获取countyCode
	 * @return
	 */
	public long getCountyCode()
	{
		return countyCode;
	}

	/**
	 * 设置countyCode
	 * @param countyCode
	 */
	public void setCountyCode(long countyCode)
	{
		this.countyCode = countyCode;
	}
}
