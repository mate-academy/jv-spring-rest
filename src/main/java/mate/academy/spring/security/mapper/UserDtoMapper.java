package mate.academy.spring.security.mapper;

import mate.academy.spring.dto.UserDto;
import mate.academy.spring.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserDtoMapper {
    public UserDto parse(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setSalt(user.getSalt());
        return userDto;
    }
}
