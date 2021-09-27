package co.com.bancolombia.model.cliente.gateways;

import co.com.bancolombia.model.cliente.Cliente;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClienteRepository {
    Mono<Cliente> create(Cliente cliente);
    Flux<Cliente> getAll();
    Mono<Cliente> putClient(Cliente cliente);
    Mono<Cliente> getClientId(String id);
    Mono<Cliente> deleteClient(String id);
}
