package mate.academy.spring.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MovieResponseDto {
    private Long id;
    private String title;
    private String description;
}
