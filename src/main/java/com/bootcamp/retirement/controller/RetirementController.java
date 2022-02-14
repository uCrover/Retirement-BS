package com.bootcamp.retirement.controller;

import com.bootcamp.retirement.model.dto.Retirement;
import com.bootcamp.retirement.service.IRetirementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/retirement")
public class RetirementController {

    private final IRetirementService service;

    @GetMapping
    public Flux<Retirement> getAllDeposits(){
        return this.service.getAll();
    }

    @GetMapping("/{numAc}")
    public Flux<Retirement> getDepositForNumAccount(@PathVariable("numAc") String numAccount){
        return this.service.getRetirementsAccount(numAccount);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Retirement> save(@RequestBody Retirement deposit){
        return this.service.saveRetirement(deposit);
    }

    @PutMapping
    public Mono<ResponseEntity<Retirement>> update(@RequestBody Retirement deposit){
        return this.service.updateRetirement(deposit).flatMap(dep -> Mono.just(ResponseEntity.ok(dep)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Retirement>> delete(@PathVariable("id") String id){
        return this.service.deleteRetirement(id).flatMap(dep -> Mono.just(ResponseEntity.ok(dep)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

}
