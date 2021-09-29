package co.com.bancolombia.mongo;

import co.com.bancolombia.model.instructor.Instructor;
import co.com.bancolombia.model.instructor.gateways.InstructorRepository;
import co.com.bancolombia.mongo.entity.InstructorEntity;
import co.com.bancolombia.mongo.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Repository
public class InstructorRepositoryAdapter extends AdapterOperations<Instructor, InstructorEntity, String, InstructorDBRepository>
    implements InstructorRepository
{

    public InstructorRepositoryAdapter(InstructorDBRepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, Instructor.class));
    }

    @Override
    public Mono<Instructor> create(Instructor instructor) {
        InstructorEntity instructorEntity = InstructorEntity
                .builder()
                .nombre(instructor.getNombre())
                .correo(instructor.getCorreo())
                .tipoPersona(instructor.getTipoPersona())
                .build();
        return repository.save(instructorEntity).map(this::toEntity);
    }

    @Override
    public Flux<Instructor> getAll() {
        return repository.findAll().map(this::toEntity);
    }


}
