package spring.rest.model.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Setter
@Getter
@Builder
@Entity
public class Posession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, unique = true, nullable = false)
    Long id;

    String name;
    BigDecimal cost;
    LocalDateTime buyTime;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    User user;

    @Override
    public String toString() {
        return "Posession{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                ", buyTime=" + buyTime +
                '}';
    }
}
