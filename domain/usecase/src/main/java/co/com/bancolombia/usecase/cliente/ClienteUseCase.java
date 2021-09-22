package co.com.bancolombia.usecase.cliente;

import co.com.bancolombia.model.cliente.Cliente;
import co.com.bancolombia.model.cliente.gateways.ClienteRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class ClienteUseCase {

    private final ClienteRepository clienteRepository;

    public Mono<Cliente> execute(Cliente cliente){
        return clienteRepository.create(cliente);
    }
}
