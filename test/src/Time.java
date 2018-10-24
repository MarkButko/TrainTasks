import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Time {

    static CountDownLatch latch = new CountDownLatch(5);
    static CountDownLatch start = new CountDownLatch(1);

    public static void main(String[] args) throws InterruptedException {

        ExecutorService service = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 5; i++) {
            service.submit(() -> {
                long time;
                latch.countDown();
                try {
                    start.await();
                    time = System.nanoTime();
                    System.out.println(time + " time  " + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        latch.await();
        System.out.println("start");
        start.countDown();
    }

}
