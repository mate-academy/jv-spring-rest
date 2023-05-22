package mate.academy.spring.dto.cinemahall;

public class CinemaHallRequestDto {
    private Integer capacity;
    private String description;

    public CinemaHallRequestDto() {
    }

    public CinemaHallRequestDto(Integer capacity, String description) {
        this.capacity = capacity;
        this.description = description;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
