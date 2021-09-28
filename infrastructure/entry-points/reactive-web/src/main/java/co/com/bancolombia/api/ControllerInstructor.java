package co.com.bancolombia.api;

import co.com.bancolombia.model.instructor.Instructor;
import co.com.bancolombia.usecase.instructor.InstructorUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/instructor", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ControllerInstructor {

    /*
    *     @PostMapping(path = "/create")
    public Mono<Cliente> create(@RequestBody Cliente cliente) {
        return clienteUseCase.execute(cliente);
    }

    *
    * */

    private final InstructorUseCase instructorUseCase;

    @GetMapping(path = "/")
    public void index(){
        System.out.println("Hola Mundo");
    }

    @GetMapping(path = "/get-all")
    public Flux<Instructor> getAll(){
        System.out.println("Get all");
        return instructorUseCase.getALl();
    }

    @PostMapping(path = "/create")
    public Mono<Instructor> create(@RequestBody Instructor instructor){
        System.out.println(instructor);
        return instructorUseCase.execute(instructor);
    }


}
