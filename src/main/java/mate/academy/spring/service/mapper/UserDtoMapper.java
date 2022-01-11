package mate.academy.spring.service.mapper;

import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.UserRequestDto;
import mate.academy.spring.model.dto.UserResponseDto;
import org.springframework.stereotype.Component;

@Component
public class UserDtoMapper {
    public UserResponseDto toDto(User user) {
        return UserResponseDto.builder()
                .id(user.getId())
                .name(user.getName())
                .lastName(user.getLastName())
                .build();
    }

    public User toModel(UserRequestDto requestDto) {
        return User.builder()
                .name(requestDto.getName())
                .lastName(requestDto.getLastName())
                .email(requestDto.getEmail())
                .build();
    }
}
