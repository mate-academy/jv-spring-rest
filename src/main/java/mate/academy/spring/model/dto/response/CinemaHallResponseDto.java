package mate.academy.spring.model.dto.response;

public class CinemaHallResponseDto {
    private Long id;
    private int capacity;
    private String description;

    public Long getId() {
        return id;
    }

    public CinemaHallResponseDto setId(Long id) {
        this.id = id;
        return this;
    }

    public int getCapacity() {
        return capacity;
    }

    public CinemaHallResponseDto setCapacity(int capacity) {
        this.capacity = capacity;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public CinemaHallResponseDto setDescription(String description) {
        this.description = description;
        return this;
    }
}
