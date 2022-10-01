package mate.academy.spring.security.mapper;

import mate.academy.spring.dto.TicketDto;
import mate.academy.spring.model.Ticket;
import org.springframework.stereotype.Component;

@Component
public class TicketDtoMapper {
    public TicketDto parse(Ticket ticket) {
        TicketDto ticketDto = new TicketDto();
        ticketDto.setId(ticket.getId());
        ticketDto.setMovieSession(ticket.getMovieSession());
        ticketDto.setShowTime(ticket.getShowTime());
        ticketDto.setUser(ticket.getUser());
        return ticketDto;
    }
}
