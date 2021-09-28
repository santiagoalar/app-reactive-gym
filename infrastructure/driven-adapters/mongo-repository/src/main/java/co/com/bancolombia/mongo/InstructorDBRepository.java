package co.com.bancolombia.mongo;

import co.com.bancolombia.mongo.entity.InstructorEntity;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface InstructorDBRepository
        extends ReactiveCrudRepository<InstructorEntity, String>, ReactiveQueryByExampleExecutor<InstructorEntity> {
}
