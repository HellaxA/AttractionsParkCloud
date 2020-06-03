package attractions.service;


import attractions.entity.Login;
import attractions.entity.User;

public class UserServiceImpl implements UserService{

    @Override
    public User validateUser(Login login) {
        return new User();
    }

    @Override
    public void register(User user) {

    }
}
