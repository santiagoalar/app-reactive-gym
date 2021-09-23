package co.com.bancolombia.mongo.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("sedes")
@Data
@Builder(toBuilder = true)
@AllArgsConstructor
public class SedeData {
    private String id;
    private String address;
    private List trainerId;
}
