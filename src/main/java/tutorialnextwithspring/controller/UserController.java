package tutorialnextwithspring.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tutorialnextwithspring.model.User;
import tutorialnextwithspring.service.UserService;



@RestController
@RequestMapping("/api/V1/")

public class UserController {

  
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public User saveUser(@RequestBody User user) {
        
        return userService.saveUser(user);
    }
    
}
