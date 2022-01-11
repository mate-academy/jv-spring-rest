package mate.academy.spring.service;

import java.util.Optional;
import mate.academy.spring.model.User;

public interface UserService extends GenericService<User> {
    Optional<User> findByEmail(String email);
}
