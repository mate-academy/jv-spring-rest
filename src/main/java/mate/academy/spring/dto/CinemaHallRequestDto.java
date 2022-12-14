package mate.academy.spring.dto;

public class CinemaHallRequestDto {
    private int capacity;
    private String description;

    public int getCapacity() {
        return capacity;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "CinemaHallRequestDto{"
                + "capacity=" + capacity
                + ", description='" + description + '\'' + '}';
    }
}
