package com.mizhousoft.geo.tianditu.modal;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * TDTGEOResponse
 *
 * @version
 */
public class TDTGEOResponse extends TDTResponse
{
	/**
	 * 版本
	 */
	@JsonProperty(value = "searchVersion")
	private String searchVersion;

	/**
	 * 位置
	 */
	@JsonProperty(value = "location")
	private TDTLocation location;

	/**
	 * 获取searchVersion
	 * 
	 * @return
	 */
	public String getSearchVersion()
	{
		return searchVersion;
	}

	/**
	 * 设置searchVersion
	 * 
	 * @param searchVersion
	 */
	public void setSearchVersion(String searchVersion)
	{
		this.searchVersion = searchVersion;
	}

	/**
	 * 获取location
	 * 
	 * @return
	 */
	public TDTLocation getLocation()
	{
		return location;
	}

	/**
	 * 设置location
	 * 
	 * @param location
	 */
	public void setLocation(TDTLocation location)
	{
		this.location = location;
	}
}
