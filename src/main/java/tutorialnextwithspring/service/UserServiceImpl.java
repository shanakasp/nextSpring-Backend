package tutorialnextwithspring.service;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import tutorialnextwithspring.entity.UserEntity;
import tutorialnextwithspring.model.User;
import tutorialnextwithspring.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);
        userRepository.save(userEntity);
       return user;
    }

}
