package com.spring.reactive.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.reactive.exception.ResourceNotFoundException;
import com.spring.reactive.model.AirlineEntity;
import com.spring.reactive.repositories.AirlineRepository;
import com.spring.reactive.service.AirlineService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AirlineServiceImpl implements AirlineService {
   
	@Autowired
	AirlineRepository airlineRepository;
	
	@Override
	public Mono<AirlineEntity> getAirlineDetailsById(String id) {
//		return Mono.just(id)
//				.flatMap(airlineRepository::findByAirlineId)
//				.switchIfEmpty(Mono.error(new ResourceNotFoundException("Find Airline","Id",id)));
		return airlineRepository.findById(id)
				.switchIfEmpty(Mono.error(new ResourceNotFoundException("Find Airline","Id",id)));
	 }

	@Override
	public Mono<AirlineEntity> updateAirlineDetails(AirlineEntity airlineEntity) {
		return airlineRepository.findById(airlineEntity.getId())
                .flatMap(p->this.airlineRepository.save(airlineEntity)
                .thenReturn(airlineEntity));		
	}

	@Override
	public Mono<Object> deleteAirline(String id) {
		return airlineRepository.findById(id)
                .flatMap(p->this.airlineRepository.deleteById(id)
                .thenReturn(p));		
	}

	@Override
	public Mono<AirlineEntity> addAirline(AirlineEntity airlineEntity) {
		return airlineRepository.save(airlineEntity);
	}

	@Override
	public Flux<AirlineEntity> findAll() {
		return airlineRepository.findAll();
	}

}
