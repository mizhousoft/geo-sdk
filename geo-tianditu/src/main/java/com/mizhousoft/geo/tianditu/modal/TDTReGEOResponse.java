package com.mizhousoft.geo.tianditu.modal;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 响应
 *
 * @version
 */
public class TDTReGEOResponse extends TDTResponse
{
	/**
	 * 结果
	 */
	@JsonProperty(value = "result")
	private TDTReGEOResult result;

	/**
	 * 获取result
	 * 
	 * @return
	 */
	public TDTReGEOResult getResult()
	{
		return result;
	}

	/**
	 * 设置result
	 * 
	 * @param result
	 */
	public void setResult(TDTReGEOResult result)
	{
		this.result = result;
	}
}
