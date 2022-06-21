package mate.academy.spring.dto;

public class MovieSessionRequestDto {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "MovieSessionRequestDto{"
                + "movieSessionId=" + id
                + '}';
    }
}
