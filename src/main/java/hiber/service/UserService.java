package hiber.service;

import hiber.model.User;

import java.util.List;

public interface UserService {

    List<User> getAll();

    User update(User user);

    void save(User user);

    void delete(User user);

}
