package mate.academy.spring.dto.request;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Accessors(chain = true)
@Setter
public class MovieRequestDto {
    private String title;
    private String description;
}
