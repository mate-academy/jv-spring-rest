package mate.academy.spring.model.dto.request;

public class CinemaHallRequestDto {
    private int capacity;
    private String description;

    public int getCapacity() {
        return capacity;
    }

    public CinemaHallRequestDto setCapacity(int capacity) {
        this.capacity = capacity;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public CinemaHallRequestDto setDescription(String description) {
        this.description = description;
        return this;
    }
}
