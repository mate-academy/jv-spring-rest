package mate.academy.spring.dto;

import java.util.List;
import mate.academy.spring.model.Ticket;
import mate.academy.spring.model.User;

public class ShoppingCartDto {
    private Long id;
    private List<Ticket> tickets;
    private User user;

    public ShoppingCartDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
