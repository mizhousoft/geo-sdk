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
	 * 结果
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
		 * 地址
		 *
		 * @version
		 */
		public class TDTAddressComponent
		{
			/**
			 * 此点最近地点信息
			 */
			@JsonProperty(value = "address")
			private String address;

			/**
			 * 此点距离最近地点信息距离
			 */
			@JsonProperty(value = "address_distance")
			private int addressDistance;

			/**
			 * 此点在最近地点信息方向
			 */
			@JsonProperty(value = "address_position")
			private String addressPosition;

			/**
			 * 国家
			 */
			@JsonProperty(value = "nation")
			private String nation;

			/**
			 * 省份编码
			 */
			@JsonProperty(value = "province_code")
			private String provinceCode;

			/**
			 * 省份
			 */
			@JsonProperty(value = "province")
			private String province;

			/**
			 * 城市
			 */
			@JsonProperty(value = "city")
			private String city;

			/**
			 * 城市编码
			 */
			@JsonProperty(value = "city_code")
			private String cityCode;

			/**
			 * 区县
			 */
			@JsonProperty(value = "county")
			private String county;

			/**
			 * 区县编码
			 */
			@JsonProperty(value = "county_code")
			private String countyCode;

			/**
			 * 距离此点最近poi点
			 */
			@JsonProperty(value = "poi")
			private String poi;

			/**
			 * 距离此点最近poi点的距离
			 */
			@JsonProperty(value = "poi_distance")
			private int poiDistance;

			/**
			 * 此点在最近poi点的方向
			 */
			@JsonProperty(value = "poi_position")
			private String poiPosition;

			/**
			 * 距离此点最近的路
			 */
			@JsonProperty(value = "road")
			private String road;

			/**
			 * 此点距离此路的距离
			 */
			@JsonProperty(value = "road_distance")
			private int roadDistance;

			/**
			 * 获取address
			 * 
			 * @return
			 */
			public String getAddress()
			{
				return address;
			}

			/**
			 * 设置address
			 * 
			 * @param address
			 */
			public void setAddress(String address)
			{
				this.address = address;
			}

			/**
			 * 获取addressDistance
			 * 
			 * @return
			 */
			public int getAddressDistance()
			{
				return addressDistance;
			}

			/**
			 * 设置addressDistance
			 * 
			 * @param addressDistance
			 */
			public void setAddressDistance(int addressDistance)
			{
				this.addressDistance = addressDistance;
			}

			/**
			 * 获取addressPosition
			 * 
			 * @return
			 */
			public String getAddressPosition()
			{
				return addressPosition;
			}

			/**
			 * 设置addressPosition
			 * 
			 * @param addressPosition
			 */
			public void setAddressPosition(String addressPosition)
			{
				this.addressPosition = addressPosition;
			}

			/**
			 * 获取nation
			 * 
			 * @return
			 */
			public String getNation()
			{
				return nation;
			}

			/**
			 * 设置nation
			 * 
			 * @param nation
			 */
			public void setNation(String nation)
			{
				this.nation = nation;
			}

			/**
			 * 获取provinceCode
			 * 
			 * @return
			 */
			public String getProvinceCode()
			{
				return provinceCode;
			}

			/**
			 * 设置provinceCode
			 * 
			 * @param provinceCode
			 */
			public void setProvinceCode(String provinceCode)
			{
				this.provinceCode = provinceCode;
			}

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
			 * 获取cityCode
			 * 
			 * @return
			 */
			public String getCityCode()
			{
				return cityCode;
			}

			/**
			 * 设置cityCode
			 * 
			 * @param cityCode
			 */
			public void setCityCode(String cityCode)
			{
				this.cityCode = cityCode;
			}

			/**
			 * 获取county
			 * 
			 * @return
			 */
			public String getCounty()
			{
				return county;
			}

			/**
			 * 设置county
			 * 
			 * @param county
			 */
			public void setCounty(String county)
			{
				this.county = county;
			}

			/**
			 * 获取countyCode
			 * 
			 * @return
			 */
			public String getCountyCode()
			{
				return countyCode;
			}

			/**
			 * 设置countyCode
			 * 
			 * @param countyCode
			 */
			public void setCountyCode(String countyCode)
			{
				this.countyCode = countyCode;
			}

			/**
			 * 获取poi
			 * 
			 * @return
			 */
			public String getPoi()
			{
				return poi;
			}

			/**
			 * 设置poi
			 * 
			 * @param poi
			 */
			public void setPoi(String poi)
			{
				this.poi = poi;
			}

			/**
			 * 获取poiDistance
			 * 
			 * @return
			 */
			public int getPoiDistance()
			{
				return poiDistance;
			}

			/**
			 * 设置poiDistance
			 * 
			 * @param poiDistance
			 */
			public void setPoiDistance(int poiDistance)
			{
				this.poiDistance = poiDistance;
			}

			/**
			 * 获取poiPosition
			 * 
			 * @return
			 */
			public String getPoiPosition()
			{
				return poiPosition;
			}

			/**
			 * 设置poiPosition
			 * 
			 * @param poiPosition
			 */
			public void setPoiPosition(String poiPosition)
			{
				this.poiPosition = poiPosition;
			}

			/**
			 * 获取road
			 * 
			 * @return
			 */
			public String getRoad()
			{
				return road;
			}

			/**
			 * 设置road
			 * 
			 * @param road
			 */
			public void setRoad(String road)
			{
				this.road = road;
			}

			/**
			 * 获取roadDistance
			 * 
			 * @return
			 */
			public int getRoadDistance()
			{
				return roadDistance;
			}

			/**
			 * 设置roadDistance
			 * 
			 * @param roadDistance
			 */
			public void setRoadDistance(int roadDistance)
			{
				this.roadDistance = roadDistance;
			}
		}

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
