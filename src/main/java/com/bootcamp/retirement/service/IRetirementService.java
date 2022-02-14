package com.bootcamp.retirement.service;

import com.bootcamp.retirement.model.dto.Retirement;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IRetirementService {

    Flux<Retirement> getAll();

    Flux<Retirement> getRetirementsAccount(String numAccount);

    Mono<Retirement> saveRetirement(Retirement retirement);

    Mono<Retirement> updateRetirement(Retirement retirement);

    Mono<Retirement> deleteRetirement(String id);


}
