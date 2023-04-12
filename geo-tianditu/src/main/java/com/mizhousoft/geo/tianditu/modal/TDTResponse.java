package com.mizhousoft.geo.tianditu.modal;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 响应
 *
 * @version  
 */
public abstract class TDTResponse
{
	/**
	 * 状态
	 */
	@JsonProperty(value = "status")
	private String status;

	/**
	 * 响应信息是否有
	 */
	@JsonProperty(value = "msg")
	private String msg;

	/**
	 * 获取status
	 * @return
	 */
	public String getStatus()
	{
		return status;
	}

	/**
	 * 设置status
	 * @param status
	 */
	public void setStatus(String status)
	{
		this.status = status;
	}

	/**
	 * 获取msg
	 * @return
	 */
	public String getMsg()
	{
		return msg;
	}

	/**
	 * 设置msg
	 * @param msg
	 */
	public void setMsg(String msg)
	{
		this.msg = msg;
	}
}
