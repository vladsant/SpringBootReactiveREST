package com.spring.reactive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.reactive.exception.ResourceNotFoundException;
import com.spring.reactive.model.AirlineEntity;
import com.spring.reactive.service.AirlineService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/airline/")
public class AirlineController {
	
	@Autowired
	AirlineService airlineService;
	
	@PostMapping()
	public Mono<AirlineEntity> addAirline(@RequestBody AirlineEntity airlineEntity){
		return airlineService.addAirline(airlineEntity);
	}
	
	@GetMapping("/all")
	public Flux<AirlineEntity> getAllAirline()
	{
		return airlineService.findAll();
	}

	@GetMapping("/{id}")
	public Mono<AirlineEntity> getAirlineDetailsById(@PathVariable("id") String id)
	{
		return airlineService.getAirlineDetailsById(id);
	}
	
	@PutMapping("/{id}")
	  public Mono<AirlineEntity> updateAirlineDetails(@PathVariable("id") String id, @RequestBody AirlineEntity airlineEntity) {
		if(id.equals(airlineEntity.getId())) {
			return airlineService.updateAirlineDetails(airlineEntity);				
		}else {
			return Mono.error(new  ResourceNotFoundException("Enter correct Airline id","Airline Id",id));
	    }
	  }
	
	@DeleteMapping("/{id}")
	  public  Mono<Object> deleteAirline(@PathVariable("id") String id) {
	    return airlineService.deleteAirline(id);
	  }
}
