package co.com.bancolombia.model.sede;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class Sede {
    private String id;
    private String sedeName;
    private String address;
    private List trainerId;
}
