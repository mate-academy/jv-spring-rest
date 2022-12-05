package mate.academy.spring.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CinemaHallDto {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;
    private int capacity;
    private String description;
}
