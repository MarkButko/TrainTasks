import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class Sema {

    public static final Semaphore semaphore = new Semaphore(3, true);
    public static final AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) {

        ExecutorService service = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10; i++) {
            service.execute(new Run());
        }
        service.shutdown();
        System.out.println("main finished");
    }

    public static class Run implements Runnable {
        @Override
        public void run() {
            try {
                semaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Aquired by " + Thread.currentThread().getName() + " current " + counter.incrementAndGet())
            ;

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            semaphore.release();
            System.out.println("Released - " + counter.decrementAndGet()+ "  "  + Thread.currentThread().getName()
            );
        }
    }
}
