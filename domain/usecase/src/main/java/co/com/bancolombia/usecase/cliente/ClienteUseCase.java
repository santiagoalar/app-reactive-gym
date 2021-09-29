package co.com.bancolombia.usecase.cliente;

import co.com.bancolombia.model.cliente.Cliente;
import co.com.bancolombia.model.cliente.gateways.ClienteRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class ClienteUseCase {

    private final ClienteRepository clienteRepository;

    public Mono<Cliente> execute(Cliente cliente){
        return clienteRepository.create(cliente);
    }

    public Flux<Cliente> getAll(){
        return clienteRepository.getAll();
    }

    public Mono<Cliente> putClient(Cliente cliente){
        return clienteRepository.getClientId(cliente.getId())
                .flatMap(cliente1 -> {
                    cliente1.setId(cliente.getId());
                    cliente1.setNombre(cliente.getNombre());
                    cliente1.setCorreo(cliente.getCorreo());
                    cliente1.setDireccion(cliente.getDireccion());
                    cliente1.setMembresia(cliente.getMembresia());
                    cliente1.setAltura(cliente.getAltura());
                    cliente1.setPeso(cliente.getPeso());
                    return  clienteRepository.putClient(cliente1);
                });
    }

    public Mono<Cliente> deleteClient(String id){
        return clienteRepository.getClientId(id)
                .flatMap(clienteId -> clienteRepository.deleteClient(clienteId.getId()));
    }
}
