package com.mizhousoft.geo.tmap.area;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.mizhousoft.geo.DistrictSearchService;
import com.mizhousoft.geo.GEOException;
import com.mizhousoft.geo.model.DistrictSearchResult;
import com.mizhousoft.geo.model.DistrictSearchResult.District;
import com.mizhousoft.geo.tmap.DemoApplication;
import com.mizhousoft.geo.tmap.excel.AreaFileParseTest;

/**
 * AreaSQLExporter
 *
 * @version
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = DemoApplication.class)
public class AreaSQLExporter
{
	String SQL_FORMAT = "INSERT INTO `exchange_area` (`id`, `name`, `parent_id`, `level`, `ctime`) VALUES (%d, '%s', %d, %d, now());";

	@Autowired
	private DistrictSearchService districtSearchService;

	private Set<Long> countyCodes = new HashSet<>(100);

	@Test
	public void search()
	{
		String filePath = AreaFileParseTest.class.getClassLoader().getResource("application.properties").getPath();
		File file = new File(filePath);
		File destFile = new File(file.getParentFile(), "area.sql");

		try
		{
			DistrictSearchResult result = districtSearchService.search("中华人民共和国", 2, false);

			List<String> sqls = new ArrayList<>(10000);

			List<District> countries = result.getDistricts();
			for (District country : countries)
			{
				List<District> provinces = country.getChildren();
				for (District province : provinces)
				{
					List<District> cities = province.getChildren();
					if (null == cities)
					{
						List<String> list = buildFirstDistrict(province);
						sqls.addAll(list);
					}
					else if (containChildCounty(cities))
					{
						List<String> list = buildThirdDistrict(province);
						sqls.addAll(list);
					}
					else
					{
						List<String> list = buildSecondaryDistrict(province);
						sqls.addAll(list);
					}
				}
			}

			FileUtils.writeLines(destFile, sqls);
		}
		catch (GEOException e)
		{
			Assertions.fail(e);
		}
		catch (IOException e)
		{
			Assertions.fail(e);
		}
	}

	private List<String> buildFirstDistrict(District province)
	{
		List<String> sqls = new ArrayList<>(100);

		long provCode = Long.valueOf(province.getCityCode());
		String provSQL = String.format(SQL_FORMAT, provCode, province.getName(), 0, 1);
		sqls.add(provSQL);

		long cityCode = provCode + 100;
		String citySQL = String.format(SQL_FORMAT, cityCode, province.getName(), provCode, 2);
		sqls.add(citySQL);

		long countyCode = cityCode + 1;
		String countySQL = String.format(SQL_FORMAT, countyCode, province.getName(), cityCode, 3);
		sqls.add(countySQL);

		return sqls;
	}

	private List<String> buildSecondaryDistrict(District province)
	{
		List<String> sqls = new ArrayList<>(100);

		long provCode = Long.valueOf(province.getCityCode());
		String provSQL = String.format(SQL_FORMAT, provCode, province.getName(), 0, 1);
		sqls.add(provSQL);

		long cityCode = provCode + 100;
		String citySQL = String.format(SQL_FORMAT, cityCode, province.getName(), provCode, 2);
		sqls.add(citySQL);

		List<District> counties = province.getChildren();
		for (int i = 0; i < counties.size(); ++i)
		{
			District county = counties.get(i);

			long countyCode = cityCode + i + 1;
			String countySQL = String.format(SQL_FORMAT, countyCode, county.getName(), cityCode, 3);
			sqls.add(countySQL);
		}

		return sqls;
	}

	private List<String> buildThirdDistrict(District province)
	{
		List<String> sqls = new ArrayList<>(100);

		long provCode = Long.valueOf(province.getCityCode());
		String provSQL = String.format(SQL_FORMAT, provCode, province.getName(), 0, 1);
		sqls.add(provSQL);

		List<District> cities = province.getChildren();
		for (District city : cities)
		{
			List<District> counties = city.getChildren();
			if (!CollectionUtils.isEmpty(counties))
			{
				long cityCode = Long.valueOf(city.getCityCode());
				String citySQL = String.format(SQL_FORMAT, cityCode, city.getName(), provCode, 2);
				sqls.add(citySQL);

				for (District county : counties)
				{
					long countyCode = Long.valueOf(county.getCityCode());
					String countySQL = String.format(SQL_FORMAT, countyCode, county.getName(), cityCode, 3);
					sqls.add(countySQL);

					countyCodes.add(countyCode);
				}
			}
			else
			{
				long cityCode = Long.valueOf(city.getCityCode());
				String citySQL = String.format(SQL_FORMAT, cityCode, city.getName(), provCode, 2);
				sqls.add(citySQL);

				long countyCode = cityCode + 1;
				while (true)
				{
					if (!countyCodes.contains(countyCode))
					{
						break;
					}

					countyCode = countyCode + 1;
				}

				String countySQL = String.format(SQL_FORMAT, countyCode, city.getName(), cityCode, 3);
				sqls.add(countySQL);

				countyCodes.add(countyCode);
			}
		}

		return sqls;
	}

	private boolean containChildCounty(List<District> cities)
	{
		if (CollectionUtils.isEmpty(cities))
		{
			return false;
		}

		for (District city : cities)
		{
			if (!CollectionUtils.isEmpty(city.getChildren()))
			{
				return true;
			}
		}

		return false;
	}
}
