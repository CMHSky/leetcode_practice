package MultiThread;

// 测试停止线程
// 1. 建议线程正常停止 --> 利用次数，不建议死循环
// 2. 建议使用标志位 --> 设置一个标志位
// 3. 不建议使用stop或destroy方法 --> 已经过时
public class TestStop implements Runnable {
    // 1. 设置一个标志位
    private boolean flag = true;

    @Override
    public void run() {
        int i = 0;
        while (flag) {
            System.out.println("run...Thread" + i++);
        }
    }

    // 2. 设置一个公开的方法停止线程
    public void stop() {
        this.flag = false;
    }

    public static void main(String[] args) throws InterruptedException {
        TestStop testStop = new TestStop();
        new Thread(testStop).start();

        for (int i = 0; i < 10; i++) {
            Thread.sleep(1);
//            System.out.println("main thread: " + i);
            if (i == 9) {
                // 调用stop()方法停止线程
                testStop.stop();
                System.out.println("线程该停止了！");
            }
        }
    }
}
