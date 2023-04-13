package com.mizhousoft.geo.tianditu.excel;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;

/**
 * 价格解析服务
 *
 * @version
 */
public class AreaFileParseTest
{
	String SQL_FORMAT = "INSERT INTO `mall_area` (`id`, `name`, `parent_id`, `level`, `ctime`) VALUES (%d, '%s', %d, %d, now());";

	@Test
	public void parse()
	{
		String filePath = AreaFileParseTest.class.getClassLoader().getResource("xzqh2020-03.xlsx").getPath();
		File file = new File(filePath);
		File destFile = new File(file.getParentFile(), "area.sql");

		AreaRowDataListener dataListener = new AreaRowDataListener();

		ExcelReader excelReader = EasyExcel.read(file, AreaRowData.class, dataListener).build();
		excelReader.readAll();

		List<AreaRowData> list = dataListener.getDataList();

		Map<String, Map<String, List<AreaRowData>>> dataMap = new HashMap<>(30);

		Map<String, List<AreaRowData>> provMap = list.stream().collect(Collectors.groupingBy(data -> data.getProvName()));
		provMap.forEach((provName, cityList) -> {
			Map<String, List<AreaRowData>> cityMap = cityList.stream().collect(Collectors.groupingBy(data -> data.getCityName()));
			dataMap.put(provName, cityMap);
		});

		List<String> sqls = new ArrayList<>(3000);

		dataMap.forEach((provName, cityMap) -> {
			AreaRowData firstData = cityMap.entrySet().iterator().next().getValue().get(0);
			long provCode = firstData.getProvCode();

			String provSQL = String.format(SQL_FORMAT, provCode, provName, 0, 1);
			sqls.add(provSQL);

			Long cityCode1 = 0l;
			if (cityMap.size() == 1)
			{
				cityCode1 = Long.valueOf(firstData.getCityCode() + 100);
				String citySQL = String.format(SQL_FORMAT, cityCode1, firstData.getCityName(), provCode, 2);
				sqls.add(citySQL);
			}

			cityMap.forEach((cityName, countyList) -> {
				AreaRowData firstCounty = countyList.get(0);
				Long cityData = 0l;
				if (cityMap.size() > 1)
				{
					cityData = firstCounty.getCityCode();
					String citySQL = String.format(SQL_FORMAT, cityData, firstCounty.getCityName(), provCode, 2);
					sqls.add(citySQL);
				}
				else
				{
					cityData = Long.valueOf(firstData.getCityCode() + 100);
				}

				for (AreaRowData county : countyList)
				{
					String countySQL = String.format(SQL_FORMAT, county.getCountyCode(), county.getCounty(), cityData, 3);
					sqls.add(countySQL);
				}
			});
		});

		try
		{
			FileUtils.writeLines(destFile, sqls);
		}
		catch (IOException e)
		{

		}
	}
}
