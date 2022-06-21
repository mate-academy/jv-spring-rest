package mate.academy.spring.dto;

public class MovieSessionResponseDto {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "MovieSessionResponseDto{"
                + "movieSessionId=" + id
                + '}';
    }
}
