package com.mizhousoft.geo.tianditu.modal;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 结构
 *
 * @version
 */
public class TDTReGEOResult
{
	/**
	 * 详细地址
	 */
	@JsonProperty(value = "formatted_address")
	private String formattedAddress;

	/**
	 * 地址
	 */
	@JsonProperty(value = "addressComponent")
	private TDTAddressComponent address;

	/**
	 * 获取formattedAddress
	 * 
	 * @return
	 */
	public String getFormattedAddress()
	{
		return formattedAddress;
	}

	/**
	 * 设置formattedAddress
	 * 
	 * @param formattedAddress
	 */
	public void setFormattedAddress(String formattedAddress)
	{
		this.formattedAddress = formattedAddress;
	}

	/**
	 * 获取address
	 * 
	 * @return
	 */
	public TDTAddressComponent getAddress()
	{
		return address;
	}

	/**
	 * 设置address
	 * 
	 * @param address
	 */
	public void setAddress(TDTAddressComponent address)
	{
		this.address = address;
	}
}
