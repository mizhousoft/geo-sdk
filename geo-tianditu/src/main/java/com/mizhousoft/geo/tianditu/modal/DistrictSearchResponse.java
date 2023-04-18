package com.mizhousoft.geo.tianditu.modal;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 搜索响应
 *
 * @version
 */
public class DistrictSearchResponse extends TDTResponse
{
	/**
	 * 数据版本
	 */
	@JsonProperty(value = "status")
	private String dataVersion;

	/**
	 * 获取dataVersion
	 * 
	 * @return
	 */
	public String getDataVersion()
	{
		return dataVersion;
	}

	/**
	 * 设置dataVersion
	 * 
	 * @param dataVersion
	 */
	public void setDataVersion(String dataVersion)
	{
		this.dataVersion = dataVersion;
	}
}
