package com.mizhousoft.geo.tmap.excel;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;

/**
 * 数据监听器
 *
 * @version
 */
public class AreaRowDataListener implements ReadListener<AreaRowData>
{
	// 价格
	private final List<AreaRowData> dataList = new ArrayList<>(10);

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void invoke(AreaRowData data, AnalysisContext context)
	{
		String provName = data.getProvName();
		if (StringUtils.isBlank(provName))
		{
			return;
		}

		int row = context.readRowHolder().getRowIndex() + 1;
		data.setRowNum(row);

		dataList.add(data);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doAfterAllAnalysed(AnalysisContext context)
	{

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void onException(Exception exception, AnalysisContext context) throws Exception
	{
		ReadListener.super.onException(exception, context);
	}

	/**
	 * 获取dataList
	 * @return
	 */
	public List<AreaRowData> getDataList()
	{
		return dataList;
	}
}
