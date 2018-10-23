package spring.rest.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.rest.model.entity.Posession;

public interface PosessionRepository extends JpaRepository<Posession, Long> {
}
