package spring.rest.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Setter
@Getter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Posession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, unique = true, nullable = false)
    Long id;

    String name;
    BigDecimal cost;
    LocalDateTime buyTime;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
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
