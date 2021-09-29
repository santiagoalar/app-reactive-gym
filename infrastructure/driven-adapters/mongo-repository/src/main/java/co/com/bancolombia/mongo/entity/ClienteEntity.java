package co.com.bancolombia.mongo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "cliente")
public class ClienteEntity {

    @Id
    private String id;
    private String nombre;
    private String correo;
    private String direccion;
    private String membresia;
    private Double altura;
    private Double peso;
    private String idInstructor;
    private String idSede;
}
