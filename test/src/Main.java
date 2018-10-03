import java.util.*;
import java.util.concurrent.ScheduledExecutorService;
import java.util.stream.Collectors;

public class Main {

    public Main() {
    }

    public static void main(String[] args) {

        List<String> strings = Arrays.asList("z,", "a", "bbf", "thirs", "a", " dff");
        List<Person> persons = Arrays.asList( new Person("name", 5), new Person("name", 77), new Person("|f", 55));
        List<Integer> ints = Arrays.asList(6,7,8,5,66,54,36,7,888);


        List<String> other = strings.stream()
                .collect(Collectors.toList());

        Map<String, Integer> macAgesByName = persons.stream()
                .collect(Collectors.toMap(Person::getName, Person::getAge, (h, j) -> h < j ? h : j));

        System.out.println(macAgesByName);

        IntSummaryStatistics statistics = ints.stream().collect(Collectors.summarizingInt(Integer::intValue));
        System.out.println(statistics);

        Optional<Integer> collect = ints.stream().max(Integer::compareTo);
        System.out.println(collect);

        Map<Boolean, Set<String>> collect1 = strings.stream().collect(Collectors.partitioningBy(s -> s.length() == 1, Collectors.toSet()));
        System.out.println(collect1);
    }

}
