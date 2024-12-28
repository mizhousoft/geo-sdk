package com.mizhousoft.geo.tmap.search;

import java.util.ArrayList;
import java.util.List;

import com.mizhousoft.commons.json.JSONException;
import com.mizhousoft.commons.json.JSONUtils;
import com.mizhousoft.commons.lang.CollectionUtils;
import com.mizhousoft.geo.DistrictSearchService;
import com.mizhousoft.geo.GEOException;
import com.mizhousoft.geo.GEOProfile;
import com.mizhousoft.geo.model.DistrictSearchResult;
import com.mizhousoft.geo.model.DistrictSearchResult.District;
import com.mizhousoft.geo.tmap.modal.TMapDistrictSearchResponse;
import com.mizhousoft.geo.tmap.modal.TMapDistrictSearchResponse.TMapDistrictData;

import kong.unirest.core.Unirest;
import kong.unirest.core.UnirestException;

/**
 * 行政区查询服务
 *
 * @version
 */
public class TMapDistrictSearchServiceImpl implements DistrictSearchService
{
	/**
	 * GEOProfile
	 */
	private GEOProfile profile;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public DistrictSearchResult search(String searchWord, int subDistrict, boolean needPolygon) throws GEOException
	{
		boolean needSubInfo = (1 == subDistrict) ? true : false;
		boolean needAll = (2 == subDistrict) ? true : false;

		String searchForamt = "{\"searchWord\":\"%s\",\"searchType\":\"1\",\"needSubInfo\":\"%b\",\"needAll\":\"%b\",\"needPolygon\":\"%b\",\"needPre\":\"true\"}";
		String postBody = String.format(searchForamt, searchWord, needSubInfo, needAll, needPolygon);

		try
		{
			String body = Unirest.get("http://api.tianditu.gov.cn/administrative").queryString("postStr", postBody)
			        .queryString("tk", profile.getAppKey()).asString().getBody();

			TMapDistrictSearchResponse response = JSONUtils.parse(body, TMapDistrictSearchResponse.class);
			if (!"100".equals(response.getReturnCode()))
			{
				throw new GEOException("District search failed, msg is " + response.getMsg() + '.');
			}

			List<District> districts = convertDistrict(response.getDataList());

			DistrictSearchResult result = new DistrictSearchResult();
			result.setDistricts(districts);

			return result;
		}
		catch (UnirestException e)
		{
			throw new GEOException(e.getMessage(), e);
		}
		catch (JSONException e)
		{
			throw new GEOException(e.getMessage(), e);
		}
	}

	private List<District> convertDistrict(List<TMapDistrictData> dataList)
	{
		List<District> districts = new ArrayList<>(10);

		for (TMapDistrictData item : dataList)
		{
			District district = new District();
			district.setName(item.getName());
			district.setLevel(item.getLevel());
			district.setCityCode(item.getCityCode());

			if (!CollectionUtils.isEmpty(item.getChildren()))
			{
				List<District> children = convertDistrict(item.getChildren());
				district.setChildren(children);
			}

			districts.add(district);
		}

		return districts;
	}

	/**
	 * 设置profile
	 * 
	 * @param profile
	 */
	public void setProfile(GEOProfile profile)
	{
		this.profile = profile;
	}
}
