package MultiThread.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
* 使用线程池
* 背景：经常创建和销毁，使用量特别大的资源，比如并发情况下的线程，对性能影响很大。
* 思路：提前创建好多个线程，放入线程池中，使用时直接获取，使用完放回池中。可以避免频繁创建销毁、实现重复利用。
* 好处：
* 1. 提高响应速度（减少了创建新线程的时间）
* 2. 降低资源消耗（重复利用线程池中线程，不需要每次都创建）
* 3. 便于线程管理
* */
public class TestThreadPool {
    public static void main(String[] args) {
        // 1. 创建服务，创建线程池
        ExecutorService service = Executors.newFixedThreadPool(10);

        // 2. 执行
        service.execute(new MyThread());
        service.execute(new MyThread());
        service.execute(new MyThread());
        service.execute(new MyThread());

        // 3. 关闭服务
        service.shutdown();
    }

}

class MyThread implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 2; i++) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
        }
    }
}