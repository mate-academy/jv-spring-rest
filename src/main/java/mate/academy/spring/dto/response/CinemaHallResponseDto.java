package mate.academy.spring.dto.response;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Accessors(chain = true)
@Setter
public class CinemaHallResponseDto {
    private Long id;
    private int capacity;
    private String description;
}
