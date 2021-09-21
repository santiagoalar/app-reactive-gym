package co.com.bancolombia.model.sede;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder(toBuilder = true)
public class Sede {
    private String id;
    private String address;
    private List trainerId;
}
