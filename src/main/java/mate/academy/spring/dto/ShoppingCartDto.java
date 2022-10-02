package mate.academy.spring.dto;

import java.util.List;

public class ShoppingCartDto {
    private Long id;
    private List<Long> tickets;
    private Long userId;

    public ShoppingCartDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Long> getTickets() {
        return tickets;
    }

    public void setTickets(List<Long> tickets) {
        this.tickets = tickets;
    }

    public Long getUser() {
        return userId;
    }

    public void setUser(Long userId) {
        this.userId = userId;
    }
}
