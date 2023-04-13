package com.mizhousoft.geo.tianditu.coder;

import com.mizhousoft.commons.json.JSONException;
import com.mizhousoft.commons.json.JSONUtils;
import com.mizhousoft.commons.restclient.RestException;
import com.mizhousoft.commons.restclient.service.RestClientService;
import com.mizhousoft.geo.GEOCoder;
import com.mizhousoft.geo.GEOException;
import com.mizhousoft.geo.GEOProfile;
import com.mizhousoft.geo.model.Address;
import com.mizhousoft.geo.model.AddressComponent;
import com.mizhousoft.geo.model.Location;
import com.mizhousoft.geo.tianditu.modal.TDTGEOResponse;
import com.mizhousoft.geo.tianditu.modal.TDTReGEOResponse;
import com.mizhousoft.geo.tianditu.modal.TDTReGEOResult;

/**
 * 地理编码接口
 *
 * @version
 */
public class TiandituGEOCoder implements GEOCoder
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
	public Location geo(String address, String city) throws GEOException
	{
		String postBody = String.format("{\"keyWord\":\"%s\"}", address);
		String requestUrl = String.format("http://api.tianditu.gov.cn/geocoder?ds={json}&tk=%s", profile.getAppKey());

		try
		{
			String body = restClientService.getForObject(requestUrl, String.class, postBody);

			TDTGEOResponse response = JSONUtils.parse(body, TDTGEOResponse.class);
			if (!"0".equals(response.getStatus()))
			{
				throw new GEOException("geo failed, msg is " + response.getMsg() + '.');
			}

			return null;
		}
		catch (RestException | JSONException e)
		{
			throw new GEOException(e.getMessage(), e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Address regeo(double lng, double lat) throws GEOException
	{
		String postBody = String.format("{'lon':\"%f\",'lat':%f,'ver':1}", lng, lat);
		String requestUrl = String.format("http://api.tianditu.gov.cn/geocoder?postStr={json}&type=geocode&tk=%s", profile.getAppKey());

		try
		{
			String body = restClientService.getForObject(requestUrl, String.class, postBody);

			TDTReGEOResponse response = JSONUtils.parse(body, TDTReGEOResponse.class);
			if (!"0".equals(response.getStatus()))
			{
				throw new GEOException("regeo failed, msg is " + response.getMsg() + '.');
			}

			TDTReGEOResult result = response.getResult();

			AddressComponent addrComponent = new AddressComponent();
			addrComponent.setProvince(result.getAddress().getProvince());
			addrComponent.setCity(result.getAddress().getCity());
			addrComponent.setDistrict(result.getAddress().getCounty());

			Address address = new Address();
			address.setFormattedAddr(result.getFormattedAddress());
			address.setAddrComponent(addrComponent);

			return address;
		}
		catch (RestException | JSONException e)
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
