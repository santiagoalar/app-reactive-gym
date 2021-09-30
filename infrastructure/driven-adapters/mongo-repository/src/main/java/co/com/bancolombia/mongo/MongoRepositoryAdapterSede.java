package co.com.bancolombia.mongo;

import co.com.bancolombia.model.sede.Sede;
import co.com.bancolombia.model.sede.gateways.SedeRepository;
import co.com.bancolombia.mongo.entities.SedeData;
import co.com.bancolombia.mongo.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class MongoRepositoryAdapterSede extends AdapterOperations<Sede, SedeData, String, MongoDBRepositorySede>
    implements SedeRepository
{

    public MongoRepositoryAdapterSede(MongoDBRepositorySede repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, Sede.class/* change for domain model */));
    }

    @Override
    public Flux<Sede> getAll() {
        return repository.findAll().map(this::toEntity);
    }

    @Override
    public Mono<Sede> getSedeById(String id) {
        return repository.findById(id).map(this::toEntity);
    }

    @Override
    public Mono<Sede> createSede(Sede sede) {
        SedeData sedeData = SedeData.builder().sedeName(sede.getSedeName()).address(sede.getAddress()).trainerId(sede.getTrainerId()).build();
        return repository.save(sedeData).map(this::toEntity);
    }

    @Override
    public Mono<Sede> updateSede(String id, Sede sede) {
        return repository.findById(id)
                .flatMap(currentSede -> {
                    currentSede.setSedeName(sede.getSedeName());
                    currentSede.setAddress(sede.getAddress());
                    currentSede.setTrainerId(sede.getTrainerId());
                    return repository.save(currentSede).map(this::toEntity);
                });
    }

    @Override
    public Mono<Void> deleteSede(String id) {
        return repository.deleteById(id);
    }
}
