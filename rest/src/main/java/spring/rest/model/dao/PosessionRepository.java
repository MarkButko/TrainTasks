package spring.rest.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import spring.rest.model.entity.Posession;

import java.util.List;

public interface PosessionRepository extends JpaRepository<Posession, Long> {
    @Query("SELECT p FROM Posession p LEFT JOIN User u WHERE u.id = ?1")
    List<Posession> findByUserId(Long userId);
}
