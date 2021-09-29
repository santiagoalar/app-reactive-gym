package co.com.bancolombia.mongo;

import co.com.bancolombia.model.cliente.Cliente;
import co.com.bancolombia.model.cliente.gateways.ClienteRepository;
import co.com.bancolombia.mongo.entity.ClienteEntity;
import co.com.bancolombia.mongo.helper.AdapterOperations;
import co.com.bancolombia.mongo.helper.ClientMapper;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class MongoRepositoryAdapter extends AdapterOperations<Cliente, ClienteEntity, String, MongoDBRepository>
implements ClienteRepository
{

    public MongoRepositoryAdapter(MongoDBRepository repository, ObjectMapper mapper) {
        super(repository, mapper, ClientMapper::convertidor);
    }

    @Override
    public Mono<Cliente> create(Cliente cliente) {
        return save(cliente);
    }

    @Override
    public Flux<Cliente> getAll() {
        return findAll();
    }

    @Override
    public Mono<Cliente> putClient(Cliente cliente) {
        return save(cliente);
    }

    @Override
    public Mono<Cliente> getClientId(String id) {
        return findById(id);
    }

    @Override
    public Mono<Cliente> deleteClient(String id) {
        return deleteById(id).then(findById(id));
    }
}
