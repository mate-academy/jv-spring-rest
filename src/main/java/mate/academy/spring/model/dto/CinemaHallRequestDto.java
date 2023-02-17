package mate.academy.spring.model.dto;

public class CinemaHallRequestDto {
    private int capacity;
    private String description;

    public CinemaHallRequestDto(int capacity, String description) {
        this.capacity = capacity;
        this.description = description;
    }

    public CinemaHallRequestDto() {
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "CinemaHall{"
                + ", capacity=" + capacity
                + ", description='" + description + '\''
                + '}';
    }
}
