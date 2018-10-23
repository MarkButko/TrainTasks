package spring.rest;

import lombok.Setter;
import spring.rest.model.entity.User;
import spring.rest.model.service.UserService;

@Setter
public class TestDataInitializer {

    UserService userService;

    public void init() {
        System.out.println("User Service = " + userService);
        for (int i = 0; i < 5; i++) {
            userService.save(
                    User.builder()
                        .name("Name_" + i)
                        .age(i)
                        .role(User.Role.CUSTOMER)
                        .build());
        }
    }
}
