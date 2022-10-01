package mate.academy.spring.security.mapper;

import mate.academy.spring.dto.ShoppingCartDto;
import mate.academy.spring.model.ShoppingCart;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartDtoMapper {
    ShoppingCartDto parse(ShoppingCart shoppingCart) {
        ShoppingCartDto shoppingCartDto = new ShoppingCartDto();
        shoppingCartDto.setId(shoppingCart.getId());
        shoppingCartDto.setUser(shoppingCart.getUser());
        shoppingCartDto.setTickets(shoppingCart.getTickets());
        return shoppingCartDto;
    }
}
