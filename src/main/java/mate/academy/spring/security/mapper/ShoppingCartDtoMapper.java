package mate.academy.spring.security.mapper;

import java.util.stream.Collectors;
import mate.academy.spring.dto.ShoppingCartDto;
import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.Ticket;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartDtoMapper {
    ShoppingCartDto parse(ShoppingCart shoppingCart) {
        ShoppingCartDto shoppingCartDto = new ShoppingCartDto();
        shoppingCartDto.setId(shoppingCart.getId());
        shoppingCartDto.setUser(shoppingCart.getUser().getId());
        shoppingCartDto.setTickets(shoppingCart.getTickets()
                .stream()
                .map(Ticket::getId)
                .collect(Collectors.toList()));
        return shoppingCartDto;
    }
}
