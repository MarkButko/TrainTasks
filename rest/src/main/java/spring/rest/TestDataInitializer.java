package spring.rest;

import lombok.Setter;
import spring.rest.model.entity.Posession;
import spring.rest.model.entity.User;
import spring.rest.model.service.PosessionService;
import spring.rest.model.service.UserService;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Setter
public class TestDataInitializer {

    UserService userService;
    PosessionService posessionService;

    int numberOfUsers = 5;
    int getNumberOfUsersWithPosessions = 3;

    public void init() {
        List<User> users = new ArrayList<>(numberOfUsers);

        for (int i = 0; i < numberOfUsers; i++) {
            users.add(User.builder()
                    .name("Name_" + i)
                    .age(i)
                    .role(User.Role.CUSTOMER)
                    .build());
        }

        users.forEach(user ->  userService.saveOrUpdate(user));

        List<Posession> posessions = new ArrayList<>(getNumberOfUsersWithPosessions);
        for (int i = 0; i < getNumberOfUsersWithPosessions; i++) {
            posessions.add( Posession.builder()
                    .buyTime(LocalDateTime.now())
                    .cost(new BigDecimal(i * 55 << 1))
                    .name("Some Posession N" + i)
                    .user(users.get(i))
                    .build());
            users.get(i).setPosessions(Arrays.asList(posessions.get(i)));
            userService.saveOrUpdate(users.get(i));
        }

    }
}
