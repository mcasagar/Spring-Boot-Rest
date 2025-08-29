package com.sb.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sb.service.TravellerServiceImpl;
import com.sb.vo.TravellerVO;

@RestController
@RequestMapping("/traveller-api")
public class TravellerController {
	@Autowired
	private TravellerServiceImpl travellerService;
	
	@PostMapping("/save")
	public ResponseEntity<String> registerTraveller(@RequestBody TravellerVO travellervo){
		try {
			String msg = travellerService.registerTraveller(travellervo);
			return new ResponseEntity<String>(msg, HttpStatus.CREATED);
		}catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("save-group")
	public ResponseEntity<String> registeredGroupOfTravellers(@RequestBody List<TravellerVO> listVo){
		try {
			String msg = travellerService.registerGroupTravellers(listVo);
			return new ResponseEntity<String>(msg, HttpStatus.CREATED);
		}catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Object> showTravellerById(@PathVariable Integer id){
		try {
			TravellerVO vo = travellerService.showTravellerById(id);
			return new ResponseEntity<Object>(vo, HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
