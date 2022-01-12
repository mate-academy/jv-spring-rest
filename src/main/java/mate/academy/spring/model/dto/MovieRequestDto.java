package mate.academy.spring.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class MovieRequestDto {
    private String title;
    private String description;
}
