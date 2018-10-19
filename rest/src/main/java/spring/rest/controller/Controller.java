package spring.rest.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.rest.model.entity.Posession;
import spring.rest.model.entity.User;
import spring.rest.model.service.PosessionService;
import spring.rest.model.service.UserService;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    UserService userService;

    @Autowired
    PosessionService posessionService;

    public Controller() {
        System.out.println("controller");
    }

    @GetMapping( "/users/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.findById(id).orElse(null);
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.findAll();
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User user) {
        return userService.saveOrUpdate(user);
    }

    @PutMapping("/users/{id}")
    public User updateUser(@RequestBody User user, @PathVariable Long id) {
        if (userService.existsById(id)) {
            return userService.saveOrUpdate(user);
        } else {
          return null;
        }
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
    }

    @GetMapping( "/users/{id}/pos")
    public List<Posession> getUserPosessions(@PathVariable Long id) {
        System.out.println("Find users pos");
        return posessionService.findAllByUserId(id);
    }
}
