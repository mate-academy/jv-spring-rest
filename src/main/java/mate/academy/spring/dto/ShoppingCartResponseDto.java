package mate.academy.spring.dto;

import java.util.List;

public class ShoppingCartResponseDto {
    private List<Long> tickets;
    private Long userId;

    public ShoppingCartResponseDto() {
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
