package mate.academy.spring.dto;

public class CinemaHallRequestDto {
    private int capacity;
    private String description;

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
