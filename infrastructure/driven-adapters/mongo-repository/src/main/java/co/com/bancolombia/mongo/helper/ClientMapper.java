package co.com.bancolombia.mongo.helper;

import co.com.bancolombia.model.cliente.Cliente;
import co.com.bancolombia.mongo.entity.ClienteEntity;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {
    public static Cliente convertidor(ClienteEntity clienteEntity){
        return Cliente.builder()
                .id(clienteEntity.getId())
                .nombre(clienteEntity.getNombre())
                .correo(clienteEntity.getCorreo())
                .direccion(clienteEntity.getDireccion())
                .membresia(clienteEntity.getMembresia())
                .altura(clienteEntity.getAltura())
                .peso(clienteEntity.getPeso())
                .idSede(clienteEntity.getIdSede())
                .idInstructor(clienteEntity.getIdInstructor())
                .build();
    }
}
