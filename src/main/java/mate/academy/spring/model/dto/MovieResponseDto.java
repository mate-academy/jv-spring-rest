package mate.academy.spring.model.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class MovieResponseDto {
    private Long id;
    private String title;
    private String description;
}
