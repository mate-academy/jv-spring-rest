package mate.academy.spring.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class MovieRequestDto {
    private String title;
    private String description;
}
