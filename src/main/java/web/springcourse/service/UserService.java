package web.springcourse.service;


import web.springcourse.models.User;

import java.util.List;

public interface UserService {
    List<User> index();
    User showUser(int id);

    void saveUser(User user);

    void updateUser(int id, User user);

    void deleteUser(int id);
}
