package mate.academy.spring.model.dto.request;

public class MovieRequestDto {
    private String title;
    private String description;

    public String getTitle() {
        return title;
    }

    public MovieRequestDto setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public MovieRequestDto setDescription(String description) {
        this.description = description;
        return this;
    }
}
