package mate.academy.spring.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MovieResponseDto {
    private Long id;
    private String title;
    private String description;
}
