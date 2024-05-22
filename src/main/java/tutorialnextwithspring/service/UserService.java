package tutorialnextwithspring.service;

import java.util.List;

import tutorialnextwithspring.model.User;

public interface UserService {

    User saveUser(User user);

    List<User> getAllUsers();

    User getUserById(Long id);

   

}
