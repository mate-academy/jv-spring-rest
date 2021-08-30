package mate.academy.spring.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MovieRequestDto {
    private String title;
    private String description;
}
