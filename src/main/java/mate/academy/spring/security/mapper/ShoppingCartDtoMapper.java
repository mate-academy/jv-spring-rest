package mate.academy.spring.security.mapper;

import java.util.stream.Collectors;
import mate.academy.spring.dto.ShoppingCartResponseDto;
import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.Ticket;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartDtoMapper {
    ShoppingCartResponseDto toDto(ShoppingCart shoppingCart) {
        ShoppingCartResponseDto shoppingCartResponseDto = new ShoppingCartResponseDto();
        shoppingCartResponseDto.setUser(shoppingCart.getUser().getId());
        shoppingCartResponseDto.setTickets(shoppingCart.getTickets()
                .stream()
                .map(Ticket::getId)
                .collect(Collectors.toList()));
        return shoppingCartResponseDto;
    }
}
