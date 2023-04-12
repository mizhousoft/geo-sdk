package com.mizhousoft.geo;

/**
 * 地址信息
 *
 * @version
 */
public class Address
{
	/**
	 * 结构化地址信息
	 */
	private String formattedAddr;

	/**
	 * 地址元素
	 */
	private AddressComponent addrComponent;

	/**
	 * 获取formattedAddr
	 * 
	 * @return
	 */
	public String getFormattedAddr()
	{
		return formattedAddr;
	}

	/**
	 * 设置formattedAddr
	 * 
	 * @param formattedAddr
	 */
	public void setFormattedAddr(String formattedAddr)
	{
		this.formattedAddr = formattedAddr;
	}

	/**
	 * 获取addrComponent
	 * 
	 * @return
	 */
	public AddressComponent getAddrComponent()
	{
		return addrComponent;
	}

	/**
	 * 设置addrComponent
	 * 
	 * @param addrComponent
	 */
	public void setAddrComponent(AddressComponent addrComponent)
	{
		this.addrComponent = addrComponent;
	}

}
