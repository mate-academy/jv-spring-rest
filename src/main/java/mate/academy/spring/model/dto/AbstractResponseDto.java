package mate.academy.spring.model.dto;

public abstract class AbstractResponseDto {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
