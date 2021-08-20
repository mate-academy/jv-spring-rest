package mate.academy.spring.dto;

import java.util.Objects;

public class CinemaHallRequestDto {
    private int capacity;
    private String description;

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
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CinemaHallRequestDto that = (CinemaHallRequestDto) o;
        return capacity == that.capacity
                && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(capacity, description);
    }

    @Override
    public String toString() {
        return "CinemaHallRequestDto{"
                + ", capacity = " + capacity
                + ", description = '" + description + '\''
                + '}';
    }
}
