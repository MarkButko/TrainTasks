import java.util.function.Predicate;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Stream.of( 123, 3554, 45).sorted(Integer::compare);
    }
}
