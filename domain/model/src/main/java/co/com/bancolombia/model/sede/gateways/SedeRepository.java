package co.com.bancolombia.model.sede.gateways;

import co.com.bancolombia.model.sede.Sede;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SedeRepository {
    Flux<Sede> getAll();
    Mono<Sede>  getSedeById(String id);
    Mono<Sede> createSede(Sede sede);
    Mono<Sede> updateSede(String id, Sede sede);
    Mono<Void> deleteSede(String id);
}
