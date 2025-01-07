package MultiThread.Lock;

import java.util.concurrent.locks.ReentrantLock;

/*
* 测试Lock锁
* */

/*
* 1. Lock是显式锁（手动开启和关闭锁），synchronized是隐式锁，出了作用域自动释放
* 2. Lock只有代码块锁，synchronized有代码块锁和方法锁
* 3. 使用Lock锁，JVM将花费较少的时间来调度线程，性能更好。并且具有更好的扩展性（提供更多的子类）
* 4. 优先使用顺序：Lock > 同步代码块 > 同步方法
* */

/*
* 可重入锁
* 1. 可重入锁就是指同一线程在外层方法获取锁的时候，再进入该线程的内层方法会自动获取锁（前提，锁对象得是同一个对象），不会因为外层方法已经获取锁，内层方法就再等待获取锁
* 2. 可重入锁也叫做递归锁，指的是同一线程外层函数获得锁之后，内层递归函数仍然可以获取该锁的代码，在同一个线程在外层方法获取锁的时候，在进入内层方法会自动获取锁（前提，锁对象得是同一个对象），不会因为外层方法已经获取锁，内层方法就再等待获取锁
* 3. Java中ReentrantLock和synchronized都是可重入锁
* 4. 可重入锁最大的作用是避免死锁
* 5. 可重入锁的原理是：通过线程获得锁的次数，来决定是否释放锁，即当线程获得锁的次数为0时，才会释放锁
* 6. 可重入锁的实现原理是：通过一个计数器来记录线程获得锁的次数，当线程获得锁时，计数器加1，当线程释放锁时，计数器减1，当计数器为0时，释放锁
* */
public class TestLock {
    public static void main(String[] args) {
        TestLock2 testLock2 = new TestLock2();

        new Thread(testLock2).start();
        new Thread(testLock2).start();
        new Thread(testLock2).start();
    }
}

class TestLock2 implements Runnable {

    private int ticketNums = 10;

    // 定义lock锁
    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            try {
                // 1. 加锁
                lock.lock();

                if (ticketNums > 0) {
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + "拿到了第" + ticketNums-- + "张票");
                } else {
                    break;
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                // 2. 解锁
                lock.unlock();
            }
        }
    }
}


