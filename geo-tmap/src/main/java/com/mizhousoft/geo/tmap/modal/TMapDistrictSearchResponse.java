package com.mizhousoft.geo.tmap.modal;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 搜索响应
 *
 * @version
 */
public class TMapDistrictSearchResponse extends TMapResponse
{
	/**
	 * 数据版本
	 */
	@JsonProperty(value = "status")
	private String dataVersion;

	/**
	 * 数据版本
	 */
	@JsonProperty(value = "data")
	private List<TMapDistrictData> dataList;

	public static class TMapDistrictData
	{
		/**
		 * 显示经度
		 */
		private double lnt;

		/**
		 * 显示纬度
		 */
		private double lat;

		/**
		 * 行政区划等级
		 */
		private String level;

		/**
		 * 行政区划名称
		 */
		private String name;

		/**
		 * 行政区划英文名称
		 */
		private String english;

		/**
		 * 四角点坐标
		 */
		private String bound;

		/**
		 * 行政区划码
		 */
		private String cityCode;

		/**
		 * 行政区划类别(省市县)
		 */
		private String adminType;

		/**
		 * 行政区划英文简称
		 */
		private String englishabbrevation;

		/**
		 * 行政区划简称
		 */
		private String nameabbrevation;

		/**
		 * 子级
		 */
		@JsonProperty(value = "child")
		private List<TMapDistrictData> children;

		/**
		 * 获取lnt
		 * 
		 * @return
		 */
		public double getLnt()
		{
			return lnt;
		}

		/**
		 * 设置lnt
		 * 
		 * @param lnt
		 */
		public void setLnt(double lnt)
		{
			this.lnt = lnt;
		}

		/**
		 * 获取lat
		 * 
		 * @return
		 */
		public double getLat()
		{
			return lat;
		}

		/**
		 * 设置lat
		 * 
		 * @param lat
		 */
		public void setLat(double lat)
		{
			this.lat = lat;
		}

		/**
		 * 获取level
		 * 
		 * @return
		 */
		public String getLevel()
		{
			return level;
		}

		/**
		 * 设置level
		 * 
		 * @param level
		 */
		public void setLevel(String level)
		{
			this.level = level;
		}

		/**
		 * 获取name
		 * 
		 * @return
		 */
		public String getName()
		{
			return name;
		}

		/**
		 * 设置name
		 * 
		 * @param name
		 */
		public void setName(String name)
		{
			this.name = name;
		}

		/**
		 * 获取english
		 * 
		 * @return
		 */
		public String getEnglish()
		{
			return english;
		}

		/**
		 * 设置english
		 * 
		 * @param english
		 */
		public void setEnglish(String english)
		{
			this.english = english;
		}

		/**
		 * 获取bound
		 * 
		 * @return
		 */
		public String getBound()
		{
			return bound;
		}

		/**
		 * 设置bound
		 * 
		 * @param bound
		 */
		public void setBound(String bound)
		{
			this.bound = bound;
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
		 * 获取adminType
		 * 
		 * @return
		 */
		public String getAdminType()
		{
			return adminType;
		}

		/**
		 * 设置adminType
		 * 
		 * @param adminType
		 */
		public void setAdminType(String adminType)
		{
			this.adminType = adminType;
		}

		/**
		 * 获取englishabbrevation
		 * 
		 * @return
		 */
		public String getEnglishabbrevation()
		{
			return englishabbrevation;
		}

		/**
		 * 设置englishabbrevation
		 * 
		 * @param englishabbrevation
		 */
		public void setEnglishabbrevation(String englishabbrevation)
		{
			this.englishabbrevation = englishabbrevation;
		}

		/**
		 * 获取nameabbrevation
		 * 
		 * @return
		 */
		public String getNameabbrevation()
		{
			return nameabbrevation;
		}

		/**
		 * 设置nameabbrevation
		 * 
		 * @param nameabbrevation
		 */
		public void setNameabbrevation(String nameabbrevation)
		{
			this.nameabbrevation = nameabbrevation;
		}

		/**
		 * 获取children
		 * 
		 * @return
		 */
		public List<TMapDistrictData> getChildren()
		{
			return children;
		}

		/**
		 * 设置children
		 * 
		 * @param children
		 */
		public void setChildren(List<TMapDistrictData> children)
		{
			this.children = children;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public String toString()
		{
			StringBuilder builder = new StringBuilder();
			builder.append("{\"");
			if (level != null)
			{
				builder.append("level\":\"");
				builder.append(level);
				builder.append("\", \"");
			}
			if (name != null)
			{
				builder.append("name\":\"");
				builder.append(name);
				builder.append("\", \"");
			}
			if (cityCode != null)
			{
				builder.append("cityCode\":\"");
				builder.append(cityCode);
			}
			builder.append("\"}");
			return builder.toString();
		}
	}

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

	/**
	 * 获取dataList
	 * 
	 * @return
	 */
	public List<TMapDistrictData> getDataList()
	{
		return dataList;
	}

	/**
	 * 设置dataList
	 * 
	 * @param dataList
	 */
	public void setDataList(List<TMapDistrictData> dataList)
	{
		this.dataList = dataList;
	}
}
