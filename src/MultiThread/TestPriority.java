package MultiThread;

/*
* 测试线程的优先级
* 1. java中线程优先级默认是5
* 2. java中线程优先级范围是1-10
* 3. 线程优先级高仅仅表示线程获取的CPU时间片的几率高，并不意味着优先级高一定先执行完
* 4. 线程优先级具有继承性，比如A线程启动B线程，B线程的优先级和A线程的优先级一样
* 5. 线程优先级具有随机性，获取CPU时间片是随机的，所以多运行几次，结果可能不一样
* */
public class TestPriority {

    public static void main(String[] args) {
        // 主线程默认优先级
        System.out.println(Thread.currentThread().getName() + "---->" + Thread.currentThread().getPriority());

        Thread t1 = new Thread(new MyPriority());
        Thread t2 = new Thread(new MyPriority());
        Thread t3 = new Thread(new MyPriority());
        Thread t4 = new Thread(new MyPriority());
        Thread t5 = new Thread(new MyPriority());
        Thread t6 = new Thread(new MyPriority());

        // 先设置优先级，再启动
        t1.start();
        t2.setPriority(Thread.MIN_PRIORITY);
        t2.start();
        t3.setPriority(4);
        t3.start();
        t4.setPriority(Thread.MAX_PRIORITY);
        t4.start();
        t5.setPriority(7);
        t5.start();
        t6.setPriority(3);
        t6.start();
    }
}

class MyPriority implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "---->" + Thread.currentThread().getPriority());
    }
}
