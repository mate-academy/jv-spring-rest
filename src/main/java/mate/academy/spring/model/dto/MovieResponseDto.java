package mate.academy.spring.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieResponseDto {
    private Long id;
    private String title;
    private String description;
}
