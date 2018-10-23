package spring.rest.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.rest.model.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
