package co.com.bancolombia.usecase.sede;

import co.com.bancolombia.model.sede.Sede;
import co.com.bancolombia.model.sede.gateways.SedeRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class SedeUseCase {
    SedeRepository serviceGateWay;

    public Flux<Sede> getAllSedes(){ return serviceGateWay.getAll(); }
    public Mono<Sede> getSedeById(String id){ return serviceGateWay.getSedeById(id); }
    public Mono<Sede> createSede(Sede sede){ return serviceGateWay.createSede(sede); }
    public Mono<Sede> updateSede(String id, Sede sede){ return serviceGateWay.updateSede(id, sede); }
    public Mono<Void> deleteSede(String id){ return serviceGateWay.deleteSede(id); }
}
