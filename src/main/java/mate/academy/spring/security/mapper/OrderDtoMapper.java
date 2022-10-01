package mate.academy.spring.security.mapper;

import mate.academy.spring.dto.OrderDto;
import mate.academy.spring.model.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderDtoMapper {
    public OrderDto parse(Order order) {
        OrderDto orderDto = new OrderDto();
        orderDto.setId(order.getId());
        orderDto.setUser(order.getUser());
        orderDto.setOrderDate(order.getOrderDate());
        orderDto.setTickets(order.getTickets());
        return orderDto;
    }
}
