package com.sb.service;

import java.util.List;

import com.sb.vo.TravellerVO;

public interface ITravellerService {
	public String registerTraveller(TravellerVO travellerVo);
	public String registerGroupTravellers(List<TravellerVO> listVo);
	public TravellerVO showTravellerById(Integer id);
}
