package mate.academy.spring.dto.cinemahall;

public class CinemaHallResponseDto {
    private Long id;
    private Integer capacity;
    private String description;

    public CinemaHallResponseDto() {
    }

    public CinemaHallResponseDto(Long id, Integer capacity, String description) {
        this.id = id;
        this.capacity = capacity;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
