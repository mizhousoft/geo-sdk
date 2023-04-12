package com.mizhousoft.geo.tianditu.modal;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 位置
 *
 * @version
 */
public class TDTLocation
{
	@JsonProperty(value = "score")
	private int score;

	/**
	 * 类别名称
	 */
	@JsonProperty(value = "level")
	private String level;

	/**
	 * 坐标点显示经度
	 */
	@JsonProperty(value = "lon")
	private double lon;

	/**
	 * 坐标点显示纬度
	 */
	@JsonProperty(value = "lat")
	private double lat;

	/**
	 * 输入信息
	 */
	@JsonProperty(value = "keyWord")
	private String keyWord;

	/**
	 * 获取score
	 * @return
	 */
	public int getScore()
	{
		return score;
	}

	/**
	 * 设置score
	 * @param score
	 */
	public void setScore(int score)
	{
		this.score = score;
	}

	/**
	 * 获取level
	 * @return
	 */
	public String getLevel()
	{
		return level;
	}

	/**
	 * 设置level
	 * @param level
	 */
	public void setLevel(String level)
	{
		this.level = level;
	}

	/**
	 * 获取lon
	 * @return
	 */
	public double getLon()
	{
		return lon;
	}

	/**
	 * 设置lon
	 * @param lon
	 */
	public void setLon(double lon)
	{
		this.lon = lon;
	}

	/**
	 * 获取lat
	 * @return
	 */
	public double getLat()
	{
		return lat;
	}

	/**
	 * 设置lat
	 * @param lat
	 */
	public void setLat(double lat)
	{
		this.lat = lat;
	}

	/**
	 * 获取keyWord
	 * @return
	 */
	public String getKeyWord()
	{
		return keyWord;
	}

	/**
	 * 设置keyWord
	 * @param keyWord
	 */
	public void setKeyWord(String keyWord)
	{
		this.keyWord = keyWord;
	}
}
