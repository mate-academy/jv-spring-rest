package mate.academy.spring.model.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class CinemaHallResponseDto {
    private Long id;
    private int capacity;
    private String description;
}
