package com.mizhousoft.geo.tianditu.excel;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
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
	String SQL_FORMAT = "INSERT INTO `exchange_area` (`id`, `name`, `parent_id`, `level`, `ctime`) VALUES (%d, '%s', %d, %d, now());";

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

		Iterator<Entry<String, Map<String, List<AreaRowData>>>> iter = dataMap.entrySet().iterator();
		while (iter.hasNext())
		{
			Entry<String, Map<String, List<AreaRowData>>> entry = iter.next();
			String provName = entry.getKey();
			Map<String, List<AreaRowData>> cityMap = entry.getValue();

			AreaRowData provData = cityMap.entrySet().iterator().next().getValue().get(0);
			long provCode = provData.getProvCode();

			String provSQL = String.format(SQL_FORMAT, provCode, provName, 0, 1);
			sqls.add(provSQL);

			Long cityCode = 0l;
			if (cityMap.size() == 1)
			{
				cityCode = Long.valueOf(provData.getCityCode() + 100);
				String citySQL = String.format(SQL_FORMAT, cityCode, provData.getCityName(), provCode, 2);
				sqls.add(citySQL);
			}

			int codeIndex = 1;

			Iterator<Entry<String, List<AreaRowData>>> citer = cityMap.entrySet().iterator();
			while (citer.hasNext())
			{
				Entry<String, List<AreaRowData>> centry = citer.next();
				List<AreaRowData> countyList = centry.getValue();

				AreaRowData firstCounty = countyList.get(0);
				if (cityMap.size() > 1)
				{
					if (firstCounty.getCityCode() == provData.getProvCode())
					{
						cityCode = provCode + codeIndex;
						codeIndex = codeIndex + 1;
					}
					else
					{
						cityCode = firstCounty.getCityCode();
					}

					String citySQL = String.format(SQL_FORMAT, cityCode, firstCounty.getCityName(), provCode, 2);
					sqls.add(citySQL);
				}

				for (AreaRowData county : countyList)
				{
					long countyCode = county.getCountyCode();
					if (countyCode == provCode)
					{
						countyCode = provCode + codeIndex;
						codeIndex = codeIndex + 1;
					}
					else if (countyCode == cityCode)
					{
						countyCode = cityCode + codeIndex;
						codeIndex = codeIndex + 1;
					}

					String countySQL = String.format(SQL_FORMAT, countyCode, county.getCounty(), cityCode, 3);
					sqls.add(countySQL);
				}
			}
		}

		try
		{
			FileUtils.writeLines(destFile, sqls);
		}
		catch (IOException e)
		{

		}
	}
}
