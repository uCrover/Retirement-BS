package com.bootcamp.retirement.service;

import com.bootcamp.retirement.model.dto.Retirement;
import com.bootcamp.retirement.repository.IRetirementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class RetirementServiceImpl implements IRetirementService{

    private final IRetirementRepository repository;

    @Override
    public Flux<Retirement> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Flux<Retirement> getRetirementsAccount(String numAccount) {
        return this.repository.findByNumAccount(numAccount);
    }

    @Override
    public Mono<Retirement> saveRetirement(Retirement retirement) {
             /*
        método para buscar el número de cuenta de la otra API bank_account-service, si encuentra...realizar restricciones
        Ahorro:con un límite máximo de movimientos mensuales.
        Cuenta corriente: sin límite de movimientos mensuales.
        Plazo fijo: solo permite un movimiento de retiro o depósito en un día específico del mes.
         */

        String today= LocalDateTime.now().toString();
        retirement.setDate(today);
        return this.repository.save(retirement);
    }

    @Override
    public Mono<Retirement> updateRetirement(Retirement retirement) {
        String id=retirement.get_id();

        return this.repository.findById(id).flatMap(ret -> {ret.set_id(id);
                                            return this.repository.save(retirement);})
                .switchIfEmpty(Mono.empty());
    }

    @Override
    public Mono<Retirement> deleteRetirement(String id) {
        return this.repository.findById(id).flatMap(r -> this.repository.deleteById(r.get_id()).thenReturn(r));
    }
}
