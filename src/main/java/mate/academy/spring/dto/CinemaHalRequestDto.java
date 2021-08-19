package mate.academy.spring.dto;

public class CinemaHalRequestDto {
    private int capacity;
    private String description;

    public CinemaHalRequestDto() {
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
}
