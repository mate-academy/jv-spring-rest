package mate.academy.spring.service.impl;

import java.util.List;
import java.util.Optional;
import mate.academy.spring.dao.UserDao;
import mate.academy.spring.model.User;
import mate.academy.spring.service.AbstractService;
import mate.academy.spring.service.UserService;
import mate.academy.spring.util.HashUtil;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends AbstractService<User, UserDao> implements UserService {
    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        super(userDao);
        this.userDao = userDao;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userDao.findByEmail(email);
    }

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public User add(User user) {
        user.setSalt(HashUtil.getSalt());
        user.setPassword(HashUtil.hashPassword(user.getPassword(), user.getSalt()));
        return userDao.add(user);
    }

    @Override
    public User get(Long id) {
        return userDao.get(id).get();
    }

    @Override
    public User update(Long id) {
        return userDao.update(id).get();
    }

    @Override
    public void delete(Long id) {
        userDao.delete(id);
    }
}
