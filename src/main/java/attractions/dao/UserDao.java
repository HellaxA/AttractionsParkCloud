package attractions.dao;


import attractions.entity.Login;
import attractions.entity.User;

public interface UserDao {
    void register(User user);
    User validateUser(Login login);
}