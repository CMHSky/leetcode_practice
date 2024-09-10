import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class Baidu {
    private static final BlockingDeque<Integer> queue = new LinkedBlockingDeque<>(1);


    public static void main(String[] args) {
        Thread producer = new Thread(new Producer(), "Producer");
        Thread consumer = new Thread(new Consumer(), "consumer");

        producer.start();
        consumer.start();
    }

    static class Producer implements Runnable {

        @Override
        public void run() {
            for (int i = 1; i <= 10; i++) {
                queue.add(i);
                System.out.println(Thread.currentThread().getName() + " produced: " + i);
            }
        }
    }

    static class Consumer implements Runnable {

        @Override
        public void run() {
            while (true) {
                int num = 0;
                try {
                    num = queue.take();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                if (num == -1) {
                    break;
                }

                System.out.println(Thread.currentThread().getName() + " consumed: " + num);
            }
        }
    }


}
