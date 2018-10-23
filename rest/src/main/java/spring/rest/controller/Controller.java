package spring.rest.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.rest.model.entity.User;
import spring.rest.model.service.UserService;

import java.util.List;

@RestController("/")
public class Controller {

    @Autowired
    UserService userService;

    public Controller() {
        System.out.println("controller");
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> getUsers() {
        return userService.findAll();
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        return "String";
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public User addUser(@RequestBody User user) {
        return userService.save(user);
    }
}
