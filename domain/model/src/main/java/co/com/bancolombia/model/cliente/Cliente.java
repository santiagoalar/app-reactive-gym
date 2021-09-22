package co.com.bancolombia.model.cliente;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Cliente {

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
