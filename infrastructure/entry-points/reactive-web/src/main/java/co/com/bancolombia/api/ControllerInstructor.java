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

    private final InstructorUseCase instructorUseCase;

    @GetMapping(path = "/get-all")
    public Flux<Instructor> getAll(){
        return instructorUseCase.getALl();
    }

    @PostMapping(path = "/create")
    public Mono<Instructor> create(@RequestBody Instructor instructor){
        return instructorUseCase.execute(instructor);
    }

    @DeleteMapping(path = "/delete/{id}")
    public Mono<Void> deleteOne(@PathVariable String id){
        return instructorUseCase.deleteOne(id);
    }

    @PutMapping(path = "/update")
    public Mono<Instructor> updateOne(@RequestBody Instructor instructor){
        return instructorUseCase.updateOne(instructor);
    }

}
