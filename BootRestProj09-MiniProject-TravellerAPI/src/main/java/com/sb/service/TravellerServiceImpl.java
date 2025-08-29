package com.sb.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sb.entity.Traveller;
import com.sb.exception.TravellerNotFoundException;
import com.sb.repository.TravellerRepository;
import com.sb.vo.TravellerVO;
@Service
public class TravellerServiceImpl implements ITravellerService {

	@Autowired
	private TravellerRepository travellerRepo;
	
	
	@Override
	public String registerTraveller(TravellerVO travellerVo) {
		//convert vo to entity
		Traveller travellerEntity = new Traveller();
		BeanUtils.copyProperties(travellerVo, travellerEntity);
		//set required data
		travellerEntity.setCreatedBy(System.getProperty("user.name"));
		int idVal = travellerRepo.save(travellerEntity).getTid(); 
		return "traveller registered with id value: " + idVal;
	}
	
	@Override
	public String registerGroupTravellers(List<TravellerVO> listVo) {
		//convert vo to entity
		List<Traveller> travellerEntityList = new ArrayList<>();
		listVo.forEach(vo -> {
			Traveller traveller = new Traveller();
			traveller.setCreatedBy(System.getProperty("user.name"));
			BeanUtils.copyProperties(vo, traveller);
			travellerEntityList.add(traveller);
		});
		List<Traveller> allTraveller = travellerRepo.saveAll(travellerEntityList);
		List<Integer> allTravellerIds = allTraveller.stream().map(t -> t.getTid()).toList();
		
		return "All traveller registered with id values: " + allTravellerIds;
	}
	
	@Override
	public TravellerVO showTravellerById(Integer id) {
		
		Traveller entity = travellerRepo.findById(id).orElseThrow( () -> new TravellerNotFoundException("Invalid id"));
		TravellerVO vo = new TravellerVO();
		
		BeanUtils.copyProperties(entity, vo);
		return vo;
	}
	
	@Override
	public List<TravellerVO> showAllTravellers(List<TravellerVO> listVo) {
		// TODO Auto-generated method stub
		return null;
	}

}
