package mate.academy.spring.model.dto;

public class MovieSessionRequestDto {
    private Long id;

    public MovieSessionRequestDto(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
