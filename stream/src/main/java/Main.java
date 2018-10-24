import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        List<Person> list = Arrays.asList(
                new Person("Name", (byte) 12, true),
                new Person("First", (byte) 22, false),
                new Person("lasy", (byte) 88, true),
                new Person("Stream", (byte) 12, false),
                new Person("Object", (byte) 65, true),
                new Person("Main", (byte) 44, false),
                new Person("Colloc", (byte) 52, false)
        );

        double avarageAge = list.stream()
                .filter(person -> person.getGender())
                .mapToInt(Person::getAge)
                .average()
                .getAsDouble();


//        list.stream()
//                .peek(person -> person.setAge((byte)(person.getAge() +(person.getGender() ? 1: -1))))
////                .sorted((person, another) -> person.getAge() - another.getAge())
//                .sorted(Comparator.comparingInt(Person::getAge))
//                .forEach(System.out::println);

        System.out.println("-------------------------------------------------------------------------");

//        Stream<Person> males = list.stream()
//                .filter(Person::getGender)
//                .peek(person -> person.setAge((byte)(person.getAge()- 1)));
//
//        Stream<Person> females = list.stream()
//                .filter(person -> ! person.getGender())
//                .peek(person -> person.setAge((byte)(person.getAge()+ 1)));
//
//        Stream.concat(males, females)
//                .sorted(Comparator.comparingInt(Person::getAge))
//                .forEach(System.out::println);

//        Map<String, Person> map = list.stream()
//                .collect(Collectors.toMap(Person::getName, Function.identity()));
//        System.out.println(map);


        TreeMap<String, Person> map = new TreeMap<>();
        map = list.stream()
                .collect(Collectors.toMap(
                        Person::getName,
                        Function.identity(),
                        (oldValue, newValue) -> oldValue,
                        TreeMap::new
                ));
//        map.entrySet().stream().forEachOrdered(System.out::println);


//        System.out.println(map.floorKey("Farst"));
//        System.out.println(map.lowerKey("Fifrst"));
//        System.out.println(map.floorKey("Colloc"));
//        System.out.println(map.lowerKey("Colloc"));


        TreeSet<Person> set = new TreeSet<>((a,b) -> 0);
        set.addAll(list);
        set.forEach(System.out::println);

    }

}
