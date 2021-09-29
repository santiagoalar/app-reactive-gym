package co.com.bancolombia.mongo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Document(collection = "instructor")
public class InstructorEntity {

    @Id
    private String id;
    private String nombre;
    private String correo;
    private Boolean tipoPersona;

}
