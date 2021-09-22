package co.com.bancolombia.model.sede;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Sede {

    private String id;
    private String nombre;
    private String direccion;
    private String telefono;
    private List<String> idInstructores;
}
