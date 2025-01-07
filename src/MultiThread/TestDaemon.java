package MultiThread;

/*
* 测试守护线程
* 1. 用户线程：自定义线程，主线程
* 2. 守护线程：为用户线程服务的，当自定义线程全部执行完毕后，守护线程自动结束
* 3. 调用setDaemon(true)方法将线程设置为守护线程
* 4. 设置守护线程需要在start()方法之前设置，否则会报错
* 5. 在守护线程中不能使用System.exit(0)方法，会报错
* 6. 在守护线程中不能使用Thread.sleep()方法，会报错
* 7. 在守护线程中不能使用Thread.yield()方法，会报错
* 8. 在守护线程中不能使用Thread.join()方法，会报错
* 9. 在守护线程中不能使用Thread.interrupt()方法，会报错
* 10. 在守护线程中不能使用Thread.suspend()方法，会报错
* 11. 在守护线程中不能使用Thread.resume()方法，会报错
* 12. 在守护线程中不能使用Thread.stop()方法，会报错
* 13. 在守护线程中不能使用Thread.notify()方法，会报错
* 14. 在守护线程中不能使用Thread.notifyAll()方法，会报错
* 15. 在守护线程中不能使用Thread.wait()方法，会报错
* */
public class TestDaemon {
    public static void main(String[] args) {
        // 守护线程
        God god = new God();
        // 用户线程
        Me me = new Me();

        // 启动守护线程
        Thread thread = new Thread(god);
        thread.setDaemon(true); // 设置为守护线程
        thread.start();

        // 启动用户线程
        new Thread(me).start();
    }
}

class Me implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 36500; i++) {
            System.out.println("开心每一天!");
        }

        System.out.println("--------end--------");
    }
}

class God implements Runnable {

    @Override
    public void run() {
        System.out.println("上帝保佑着你!");
    }
}
