package com.mizhousoft.geo.model;

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
	 * 地址元素
	 *
	 * @version
	 */
	public static class AddressComponent
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

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("{\"");
		if (formattedAddr != null)
		{
			builder.append("formattedAddr\":\"");
			builder.append(formattedAddr);
			builder.append("\", \"");
		}
		if (addrComponent != null)
		{
			builder.append("addrComponent\":\"");
			builder.append(addrComponent);
		}
		builder.append("\"}");
		return builder.toString();
	}
}
