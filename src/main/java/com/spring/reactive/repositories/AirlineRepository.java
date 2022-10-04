package com.spring.reactive.repositories;

import org.springframework.data.couchbase.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.reactive.model.AirlineEntity;

import reactor.core.publisher.Flux;

@Repository
public interface AirlineRepository extends ReactiveCrudRepository<AirlineEntity, String> {
	@Query("#{#n1ql.selectEntity} WHERE type=\"airline\"") 
	public Flux<AirlineEntity> findAll();
}