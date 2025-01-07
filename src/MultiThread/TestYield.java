package MultiThread;

/*
* 线程礼让
* 1. 礼让线程，让当前正在执行的线程暂停，但不阻塞
* 2. 让线程从运行状态转为就绪状态，让CPU重新调度，礼让不一定成功，看CPU心情
* 3. 礼让的是时间片
* 4. 礼让的是同优先级线程
* 5. 礼让线程不会释放锁
* 6. 礼让线程是让同优先级线程之间切换，高优先级线程不受影响
* */
public class TestYield {
    public static void main(String[] args) {
        MyYield myYield = new MyYield();

        new Thread(myYield, "线程A").start();
        new Thread(myYield, "线程B").start();
    }
}

class MyYield implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "线程开始执行");
        Thread.yield();
        System.out.println(Thread.currentThread().getName() + "线程礼让后继续执行");
    }
}

