package mate.academy.spring.dto;

public class CinemaHallResponseDto {
    private Long id;
    private int capacity;
    private String description;

    public Long getId() {
        return id;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getDescription() {
        return description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
