package com.mizhousoft.geo;

/**
 * 配置信息
 *
 * @version
 */
public class GEOProfile
{
	/**
	 * 密钥
	 */
	private volatile String appKey;

	/**
	 * 获取appKey
	 * 
	 * @return
	 */
	public String getAppKey()
	{
		return appKey;
	}

	/**
	 * 设置appKey
	 * 
	 * @param appKey
	 */
	public void setAppKey(String appKey)
	{
		this.appKey = appKey;
	}
}
