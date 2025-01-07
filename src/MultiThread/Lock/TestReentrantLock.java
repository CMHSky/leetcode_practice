package MultiThread.Lock;

/*
* 使用AQS手动实现一个可重入锁
* */

import java.util.concurrent.atomic.AtomicInteger;

/*
* 阻塞策略
* 1. wait()：需要和synchronized一起使用，在可重入锁中不适用；
* 2. sleep()：ReentrantLock底层是无限期的阻塞，并且需要手动唤醒，sleep在可重入锁中不适用；
* 3. park()：暂停线程，可重入锁的主要实现原理之一；
* 4. while(true) 自旋：大量消耗CPU资源，无法保证后续线程的执行顺序（非公平锁）。
* */
public class TestReentrantLock {
    public static void main(String[] args) {
        TestLock3 testLock3 = new TestLock3();

        new Thread(testLock3, "小明").start();
        new Thread(testLock3, "小红").start();
        new Thread(testLock3, "黄牛").start();
    }
}

class TestLock3 implements Runnable {

    private int ticketNums = 10;

    // 定义lock锁
    private final CustomizedReentrantLock lock = new CustomizedReentrantLock();

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

class CustomizedReentrantLock {

    // 使用CAS保证state状态修改的原子性，保证同一时刻只有一个线程成功得改变了state的值
    private AtomicInteger state = new AtomicInteger(0);

    public void lock() {
        // 判断当前线程是否需要阻塞
        // 当前线程如果成功修改了state的值，那么则表示获取到了锁，程序正常执行，反之则自旋阻塞
        // 但是如果多个线程同时自旋的话，那么会形成非公平锁
        while (!state.compareAndSet(0, 1)) {

        }

        System.out.println(Thread.currentThread().getName() + "成功获取锁!");
    }

    public void unlock() {
        state.set(0);
        System.out.println(Thread.currentThread().getName() + "成功释放锁!");
    }
}

