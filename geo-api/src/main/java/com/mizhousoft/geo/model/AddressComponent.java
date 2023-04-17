package com.mizhousoft.geo.model;

/**
 * 地址元素
 *
 * @version
 */
public class AddressComponent
{
	/**
	 * 省名
	 */
	private String province;

	/**
	 * 城市名
	 */
	private String city;

	/**
	 * 区县名
	 */
	private String district;

	/**
	 * 获取province
	 * 
	 * @return
	 */
	public String getProvince()
	{
		return province;
	}

	/**
	 * 设置province
	 * 
	 * @param province
	 */
	public void setProvince(String province)
	{
		this.province = province;
	}

	/**
	 * 获取city
	 * 
	 * @return
	 */
	public String getCity()
	{
		return city;
	}

	/**
	 * 设置city
	 * 
	 * @param city
	 */
	public void setCity(String city)
	{
		this.city = city;
	}

	/**
	 * 获取district
	 * 
	 * @return
	 */
	public String getDistrict()
	{
		return district;
	}

	/**
	 * 设置district
	 * 
	 * @param district
	 */
	public void setDistrict(String district)
	{
		this.district = district;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("{\"");
		if (province != null)
		{
			builder.append("province\":\"");
			builder.append(province);
			builder.append("\", \"");
		}
		if (city != null)
		{
			builder.append("city\":\"");
			builder.append(city);
			builder.append("\", \"");
		}
		if (district != null)
		{
			builder.append("district\":\"");
			builder.append(district);
		}
		builder.append("\"}");
		return builder.toString();
	}
}
