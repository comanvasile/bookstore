package repository;

import model.User;

import java.util.List;

public interface UserRepository {
    List<User> findAll();

    User findById(Long id);

    User create(User user);

    User update(User user);

    boolean deleteById(Long id);

    User findByUsername(String username);
}
