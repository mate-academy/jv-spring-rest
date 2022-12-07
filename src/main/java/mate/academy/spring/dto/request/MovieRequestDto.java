package mate.academy.spring.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MovieRequestDto {
    private String title;
    private String description;
}
