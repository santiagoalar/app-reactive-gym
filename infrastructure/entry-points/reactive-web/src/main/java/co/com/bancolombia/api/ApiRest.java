package co.com.bancolombia.api;
import co.com.bancolombia.model.sede.Sede;
import co.com.bancolombia.usecase.sede.SedeUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ApiRest {
    private final SedeUseCase useCase;


    @GetMapping(path = "/all")
    public Flux<Sede> getAllSedes() {
        return useCase.getAllSedes();
    }

    @GetMapping(path = "/byId/{id}")
    public Mono<Sede> getById(@PathVariable String id){
        return useCase.getSedeById(id);
    }

    @PostMapping(path = "/sede/")
    public Mono<Sede> createSede(@RequestBody Sede sede) { return useCase.createSede(sede); }

    @PutMapping(path = "/update/{id}")
    public Mono<Sede> updateSede(@PathVariable String id, @RequestBody Sede sede) { return useCase.updateSede(id, sede); }

    @DeleteMapping(path = "delete/{id}")
    public Mono<Void> deleteSede(@PathVariable String id){ return useCase.deleteSede(id); }
}
