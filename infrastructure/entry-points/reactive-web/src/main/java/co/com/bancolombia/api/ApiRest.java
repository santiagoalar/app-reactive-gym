package co.com.bancolombia.api;
import co.com.bancolombia.model.cliente.Cliente;
import co.com.bancolombia.usecase.cliente.ClienteUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/client", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ApiRest {
    private final ClienteUseCase clienteUseCase;


    @PostMapping(path = "/create")
    public Mono<Cliente> create(Cliente cliente) {
        return clienteUseCase.execute(cliente);
    }
}
