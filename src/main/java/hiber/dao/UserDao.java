package hiber.dao;

import hiber.model.User;

import java.util.List;

public interface UserDao {

    List<User> getAll();

    User update(User user);

    void save(User user);

    void delete(User user);

    User findById(Long id);

}
