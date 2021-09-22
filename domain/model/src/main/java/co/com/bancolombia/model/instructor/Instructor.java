package co.com.bancolombia.model.instructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Instructor {

    private String id;
    private String nombre;
    private String correo;
    private Boolean tipoPersona;


}
