package mate.academy.spring.dto;

public class MovieRequestDto {
    private String title;
    private String description;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "MovieRequestDto{"
                + "title='" + title + '\''
                + ", description='" + description + '\'' + '}';
    }
}
