package com.bootcamp.retirement.repository;

import com.bootcamp.retirement.model.dto.Retirement;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface IRetirementRepository extends ReactiveMongoRepository<Retirement,String> {

    Flux<Retirement> findByNumAccount(String numAccount);

}
