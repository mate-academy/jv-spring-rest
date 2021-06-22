package mate.academy.spring.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MovieRequestDto {
    private String title;
    private String description;
}
