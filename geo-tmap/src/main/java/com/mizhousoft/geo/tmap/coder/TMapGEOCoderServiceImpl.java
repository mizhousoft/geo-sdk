package com.mizhousoft.geo.tmap.coder;

import com.mizhousoft.commons.json.JSONException;
import com.mizhousoft.commons.json.JSONUtils;
import com.mizhousoft.commons.restclient.RestException;
import com.mizhousoft.geo.GEOCoderService;
import com.mizhousoft.geo.GEOException;
import com.mizhousoft.geo.GEOProfile;
import com.mizhousoft.geo.model.Address;
import com.mizhousoft.geo.model.Address.AddressComponent;
import com.mizhousoft.geo.model.Location;
import com.mizhousoft.geo.tmap.modal.TMapGEOResponse;
import com.mizhousoft.geo.tmap.modal.TMapGEOResponse.TMapLocation;
import com.mizhousoft.geo.tmap.modal.TMapReGEOResponse;
import com.mizhousoft.geo.tmap.modal.TMapReGEOResponse.TMapReGEOResult;

import kong.unirest.core.Unirest;

/**
 * 地理编码接口
 *
 * @version
 */
public class TMapGEOCoderServiceImpl implements GEOCoderService
{
	/**
	 * GEOProfile
	 */
	private GEOProfile profile;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Location geo(String address, String city) throws GEOException
	{
		String postBody = String.format("{\"keyWord\":\"%s\"}", address);

		try
		{
			String body = Unirest.get("http://api.tianditu.gov.cn/geocoder").queryString("ds", postBody)
			        .queryString("tk", profile.getAppKey()).asString().getBody();

			TMapGEOResponse response = JSONUtils.parse(body, TMapGEOResponse.class);
			if (!"0".equals(response.getStatus()))
			{
				throw new GEOException("geo failed, msg is " + response.getMsg() + '.');
			}

			TMapLocation tMapLocation = response.getLocation();

			Location location = new Location();
			location.setLat(tMapLocation.getLat());
			location.setLng(tMapLocation.getLon());
			location.setLevel(tMapLocation.getLevel());

			return location;
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

		try
		{
			String body = Unirest.get("http://api.tianditu.gov.cn/geocoder").queryString("postStr", postBody).queryString("type", "geocode")
			        .queryString("tk", profile.getAppKey()).asString().getBody();

			TMapReGEOResponse response = JSONUtils.parse(body, TMapReGEOResponse.class);
			if (!"0".equals(response.getStatus()))
			{
				throw new GEOException("regeo failed, lng is " + lng + ", lat is " + lat + ", msg is " + response.getMsg() + '.');
			}

			TMapReGEOResult result = response.getResult();

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
}
