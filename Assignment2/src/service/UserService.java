package service;

import model.User;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

public interface UserService  {
    User save(User user);

    void delete(Long id);

    User login(String username, String password);

    List<User> findAll();

    User findByUsername(String username);

    User findById(Long id);


}
