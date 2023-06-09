package com.mizhousoft.geo.model;

import java.util.List;

/**
 * 查询结果
 *
 * @version
 */
public class DistrictSearchResult
{
	/**
	 * 行政区划列表
	 */
	private List<District> districts;

	public static class District
	{
		/**
		 * 行政区划名称
		 */
		private String name;

		/**
		 * 行政区划等级
		 */
		private String level;

		/**
		 * 行政区划码
		 */
		private String cityCode;

		/**
		 * 子级
		 */
		private List<District> children;

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
		 * 获取children
		 * 
		 * @return
		 */
		public List<District> getChildren()
		{
			return children;
		}

		/**
		 * 设置children
		 * 
		 * @param children
		 */
		public void setChildren(List<District> children)
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
			if (name != null)
			{
				builder.append("name\":\"");
				builder.append(name);
				builder.append("\", \"");
			}
			if (level != null)
			{
				builder.append("level\":\"");
				builder.append(level);
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
	 * 获取districts
	 * 
	 * @return
	 */
	public List<District> getDistricts()
	{
		return districts;
	}

	/**
	 * 设置districts
	 * 
	 * @param districts
	 */
	public void setDistricts(List<District> districts)
	{
		this.districts = districts;
	}
}
