package co.com.bancolombia.mongo;

import co.com.bancolombia.model.sede.Sede;
import co.com.bancolombia.mongo.entities.SedeData;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;

public interface MongoDBRepositorySede extends ReactiveMongoRepository<SedeData, String>, ReactiveQueryByExampleExecutor<SedeData> {
}
