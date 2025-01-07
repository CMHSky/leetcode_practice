package MultiThread;

/*
* 线程休眠
* 1. sleep(time)指定当前线程睡眠的毫秒数
* 2. sleep存在异常InterruptedException
* 3. sleep时间到达后线程进入就绪状态
* 4. sleep可以模拟网络延时、倒计时等
* 5. sleep时间到达后线程进入就绪状态，时间没到，线程处于阻塞状态
* 6. sleep可以传递n毫秒
* 7. sleep可以调用静态方法
* 8. 一个线程一个时间只能调用一次sleep
* */

// sleep应用一：模拟网络延时：放大问题的发生性
public class TestSleep implements Runnable {
    // 票数，共享资源
    private int ticketNums = 10;

    @Override
    public void run() {
        while (true) {
            if (ticketNums <= 0) {
                break;
            }

            // 模拟延时
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println(Thread.currentThread().getName() + "拿到了第"+ticketNums--+"张票");
        }
    }

    public static void main(String[] args) {
        TestThread3 testThread3 = new TestThread3();

        new Thread(testThread3, "小明").start();
        new Thread(testThread3, "老师").start();
        new Thread(testThread3, "黄牛党").start();
    }
}
