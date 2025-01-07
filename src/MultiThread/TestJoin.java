package MultiThread;

/*
* 线程合并join（插队）
* 1. join方法，等待该线程终止
* 2. 可以设置等待时间
* 3. join方法，底层使用wait方法实现
* 4. join方法，可以中断等待
* 5. join方法，可以抛出异常
* */
public class TestJoin implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("线程VIP来了" + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // 启动线程
        TestJoin testJoin = new TestJoin();
        Thread thread = new Thread(testJoin);
        thread.start();

        // 主线程
        for (int i = 0; i < 500; i++) {
            if (i == 200) {
                thread.join(); // 插队，等待插队线程执行结束才能继续跑
            }

            System.out.println("主线程" + i);
        }
    }
}
