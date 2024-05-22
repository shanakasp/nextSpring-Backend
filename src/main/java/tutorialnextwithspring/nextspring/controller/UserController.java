package tutorialnextwithspring.nextspring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tutorialnextwithspring.nextspring.model.User;
import tutorialnextwithspring.nextspring.service.UserService;






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
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    
    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
       User user = null;
       user = userService.getUserById(id);
       return  ResponseEntity.ok(user);
    }
    
    @DeleteMapping("/user/{id}")
public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable("id") Long id) {
    boolean deleted = userService.deleteUser(id);
    Map<String, Boolean> response = new HashMap<>();
    response.put("deleted", deleted);
    return ResponseEntity.ok(response);
}

@PutMapping("/users/{id}")
public ResponseEntity<User> updateUser(@PathVariable("id") Long id, @RequestBody User user) {
    User updatedUser = userService.updateUser(id, user);
    if (updatedUser != null) {
        return ResponseEntity.ok(updatedUser);
    } else {
        return ResponseEntity.notFound().build();
    }
}

    
}
