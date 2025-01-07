package MultiThread;

// 创建线程方式二：实现Runnable接口，重写run()方法，执行线程需要丢入runnable接口实现类，调用start开启线程
public class TestRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("thread: " + i);
        }
    }

    public static void main(String[] args) {
        // 创建一个线程对象
        TestRunnable runnable = new TestRunnable();
        Thread thread = new Thread(runnable);
        // 调用start()方法开启线程
        thread.start();

        for (int i = 0; i < 20; i++) {
            System.out.println("main thread: " + i);
        }
    }
}
