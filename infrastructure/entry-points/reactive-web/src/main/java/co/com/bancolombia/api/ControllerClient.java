package co.com.bancolombia.api;
import co.com.bancolombia.model.cliente.Cliente;
import co.com.bancolombia.usecase.cliente.ClienteUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/client", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ControllerClient {
    private final ClienteUseCase clienteUseCase;


    @PostMapping(path = "/create")
    public Mono<Cliente> create(@RequestBody Cliente cliente) {
        return clienteUseCase.execute(cliente);
    }

    @GetMapping(path = "/all")
    public Flux<Cliente> getAll() {
        return clienteUseCase.getAll();
    }
}
