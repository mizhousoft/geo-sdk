package com.mizhousoft.geo.tianditu.search;

import com.mizhousoft.commons.restclient.RestException;
import com.mizhousoft.commons.restclient.service.RestClientService;
import com.mizhousoft.geo.DistrictSearchService;
import com.mizhousoft.geo.GEOException;
import com.mizhousoft.geo.GEOProfile;
import com.mizhousoft.geo.model.DistrictSearchResult;

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
	 * REST服务
	 */
	private RestClientService restClientService;

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

		String requestUrl = String.format("http://api.tianditu.gov.cn/administrative?postStr={json}&tk=%s", profile.getAppKey());

		try
		{
			String body = restClientService.getForObject(requestUrl, String.class, postBody);
			System.out.println(body);

			return null;
		}
		catch (RestException e)
		{
			throw new GEOException(e.getMessage(), e);
		}
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

	/**
	 * 设置restClientService
	 * 
	 * @param restClientService
	 */
	public void setRestClientService(RestClientService restClientService)
	{
		this.restClientService = restClientService;
	}
}
