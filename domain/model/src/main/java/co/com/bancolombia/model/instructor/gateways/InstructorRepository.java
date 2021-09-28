package co.com.bancolombia.model.instructor.gateways;

import co.com.bancolombia.model.instructor.Instructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface InstructorRepository {
    Mono<Instructor> create(Instructor instructor);
    Flux<Instructor> getAll();

}
