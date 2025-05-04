package mate.academy.spring.dto.response;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Accessors(chain = true)
@Setter
public class MovieResponseDto {
    private Long id;
    private String title;
    private String description;
}
