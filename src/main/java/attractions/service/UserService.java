package attractions.service;

import attractions.entity.Login;
import attractions.entity.User;

public interface UserService {
    User validateUser(Login login);

    void register(User user);
}
