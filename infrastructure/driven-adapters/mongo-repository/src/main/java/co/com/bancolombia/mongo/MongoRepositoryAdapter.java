package co.com.bancolombia.mongo;

import co.com.bancolombia.model.cliente.Cliente;
import co.com.bancolombia.model.cliente.gateways.ClienteRepository;
import co.com.bancolombia.mongo.entity.ClienteEntity;
import co.com.bancolombia.mongo.helper.AdapterOperations;
import co.com.bancolombia.mongo.helper.ClientMapper;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
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
}
