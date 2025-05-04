package mate.academy.spring.dto.request;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Accessors(chain = true)
@Setter
public class CinemaHallRequestDto {
    private int capacity;
    private String description;
}
