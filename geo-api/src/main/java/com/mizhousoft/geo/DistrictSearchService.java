package com.mizhousoft.geo;

import com.mizhousoft.geo.model.DistrictSearchResult;

/**
 * 行政区查询服务
 *
 * @version
 */
public interface DistrictSearchService
{
	/**
	 * 搜索行政区
	 * 0：不返回下级行政区
	 * 1：返回下一级行政区
	 * 2：返回所有子级行政区
	 * 
	 * @param searchWord
	 * @param subDistrict 显示下级行政区级数
	 *            0：不返回下级行政区
	 *            1：返回下一级行政区
	 *            2：返回所有子级行政区
	 * @param needPolygon 是否需要行政区划范围
	 * @throws GEOException
	 */
	DistrictSearchResult search(String searchWord, int subDistrict, boolean needPolygon) throws GEOException;
}
