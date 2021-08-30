package mate.academy.spring.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CinemaHallResponseDto {
    private Long id;
    private int capacity;
    private String description;
}
