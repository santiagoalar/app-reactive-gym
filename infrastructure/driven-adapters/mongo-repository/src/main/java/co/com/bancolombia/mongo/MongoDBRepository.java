package co.com.bancolombia.mongo;

import co.com.bancolombia.model.cliente.Cliente;
import co.com.bancolombia.mongo.entity.ClienteEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;

public interface MongoDBRepository extends ReactiveMongoRepository<ClienteEntity, String>, ReactiveQueryByExampleExecutor<ClienteEntity> {
}
