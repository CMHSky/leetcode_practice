package MultiThread.Synchronized;

/*
* 未加入同步机制，不安全的买票场景
* */

/*
* 锁的粒度
* 对于同步成员方法，锁是当前实例对象(this)
* */
// TODO 线程不安全，有负数
public class UnsafeBuyTicket {
    public static void main(String[] args) {
        // 该对象被加锁
        BuyTicket buyTicket = new BuyTicket();

        new Thread(buyTicket, "小明").start();
        new Thread(buyTicket, "小红").start();
        new Thread(buyTicket, "黄牛").start();
    }

}

// TODO TO BE LOCKED
class BuyTicket implements Runnable {

    // 票
    private int ticketNums = 10;

    // 停止标志位
    private boolean flag = true;

    @Override
    public void run() {
        while (flag) {
            // 买票
            try {
                buy();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    // synchronized 加锁，保证同一时刻只有一个线程在买票，相当于一个排队的机制
    // 锁的是this对象
    private synchronized void buy() throws InterruptedException {
        // 判断是否有票
        if (ticketNums <= 0) {
            flag = false;
            return;
        }

        // 模拟延时
        Thread.sleep(500);

        System.out.println(Thread.currentThread().getName() + "买到了第" + ticketNums-- + "张票");
    }
}
