package mate.academy.spring.model.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
public class CinemaHallResponseDto {
    private Long id;
    private int capacity;
    private String description;
}
