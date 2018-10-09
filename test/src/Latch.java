import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Latch {

    static CountDownLatch start = new CountDownLatch(5);
    static CountDownLatch inter = new CountDownLatch(1);
    static CountDownLatch end = new CountDownLatch(5);
    static List<String> strings = Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) throws InterruptedException {
        List<Thread> list = Stream.generate(() -> new Thread(new Run()))
                .limit(5)
                .collect(Collectors.toList());

        list.forEach(Thread::start);
        start.await();
        strings.add("Start");
        inter.countDown();
        end.await();
        strings.add("End");
        System.out.println(strings);
    }

    public static class Run implements Runnable {

        @Override
        public void run() {
            start.countDown();
            try {
                inter.await();
                strings.add("Running");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            end.countDown();
        }
    }
}
