package com.mizhousoft.geo.tmap.excel;

import cn.idev.excel.annotation.ExcelIgnore;

/**
 * 数据
 *
 * @version
 */
public abstract class ExcelRowData
{
	// 当前行数
	@ExcelIgnore
	protected int rowNum;

	/**
	 * 获取rowNum
	 * 
	 * @return
	 */
	public int getRowNum()
	{
		return rowNum;
	}

	/**
	 * 设置rowNum
	 * 
	 * @param rowNum
	 */
	public void setRowNum(int rowNum)
	{
		this.rowNum = rowNum;
	}
}
