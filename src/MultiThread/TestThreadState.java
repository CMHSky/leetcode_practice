package MultiThread;

/*
* 观察测试线程的状态
* 1. 新建状态 NEW
* 2. 运行状态 RUNNABLE
* 3. 阻塞状态 BLOCKED
* 4. 等待状态 WAITING
* 5. 定时等待状态 TIMED_WAITING
* 6. 终止状态 TERMINATED
* */
public class TestThreadState {
    public static void main(String[] args) throws InterruptedException {
        // 创建线程
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            System.out.println("//////////////");
        });

        // 观察状态
        // NEW 新建状态
        Thread.State state = thread.getState();
        System.out.println(state);

        // 观察启动后
        // RUNNABLE 线程启动
        thread.start();
        state = thread.getState();
        System.out.println(state);

        while (state != Thread.State.TERMINATED) { // 只要线程不终止，就一直输出状态
            // TIMED_WAITING 定时等待状态
            Thread.sleep(100);
            state = thread.getState(); // 更新状态
            System.out.println(state);
        }

        // 终止之后的线程不能再次启动
//        thread.start();
    }
}
