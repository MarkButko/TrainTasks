import lombok.*;

import java.util.Objects;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    String name;
    Byte age;
    Boolean gender;

    @Override
    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Person person = (Person) o;
//        return Objects.equals(name, person.name) &&
//                Objects.equals(age, person.age) &&
//                Objects.equals(gender, person.gender);
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, gender);
    }
}
