package co.com.bancolombia.model.cliente.gateways;

import co.com.bancolombia.model.cliente.Cliente;
import reactor.core.publisher.Mono;

public interface ClienteRepository {
    Mono<Cliente> create(Cliente cliente);
}
