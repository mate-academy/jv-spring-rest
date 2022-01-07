package mate.academy.spring.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto {
    private Long id;
    private String name;
    private String lastName;
    private String email;
    @ToString.Exclude
    private String password;
    @ToString.Exclude
    private byte[] salt;
}
