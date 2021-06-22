package mate.academy.spring.model.dto;

import lombok.Data;

@Data
public class MovieResponseDto {
    private Long id;
    private String title;
    private String description;

    public MovieResponseDto(Long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }
}
