package co.com.bancolombia.usecase.instructor;

import co.com.bancolombia.model.cliente.Cliente;
import co.com.bancolombia.model.instructor.Instructor;
import co.com.bancolombia.model.instructor.gateways.InstructorRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class InstructorUseCase {

    private final InstructorRepository instructorRepository;

    public Mono<Instructor> execute(Instructor instructor){
        return instructorRepository.create(instructor);
    }

    public Flux<Instructor> getALl(){
        return instructorRepository.getAll();
    }
}
