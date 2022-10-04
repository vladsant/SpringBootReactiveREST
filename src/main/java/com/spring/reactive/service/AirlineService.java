package com.spring.reactive.service;

import com.spring.reactive.model.AirlineEntity;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AirlineService {
	public Mono<AirlineEntity> addAirline(AirlineEntity airlineEntity);	
	public Mono<AirlineEntity> getAirlineDetailsById(String id);
	public Mono<AirlineEntity> updateAirlineDetails(AirlineEntity airlineEntity);
	public Mono<Object>  deleteAirline(String id);
	public Flux<AirlineEntity> findAll();
}
