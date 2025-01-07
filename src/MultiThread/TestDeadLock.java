package MultiThread;

/*
* 死锁的形成条件
* 1. 互斥条件：资源是独占的且只能被一个进程使用
* 2. 请求与保持条件：一个进程因请求资源而阻塞时，对已获得的资源保持不放
* 3. 不剥夺条件：进程已获得的资源，在未使用完之前，不能强行剥夺
* 4. 循环等待条件：若干个进程之间形成一种头尾相接的循环等待资源关系
* 5. 死锁的预防：破坏其中一个条件
* 6. 死锁的避免：银行家算法
* 7. 死锁的检测：资源分配图
* 8. 死锁的解除：剥夺资源
* 9. 死锁的避免：资源有序分配
* */

// 死锁：多个线程互相抱着对方需要的资源，然后形成僵持
public class TestDeadLock {
    public static void main(String[] args) {
        Makeup m1 = new Makeup(0, "小美");
        Makeup m2 = new Makeup(1, "小丽");
        m1.start();
        m2.start();
    }
}

// 口红
class Lipstick {

}

// 镜子
class Mirror {

}

class Makeup extends Thread {

    // 资源
    // 需要的资源只有一份，使用static来保证只有一份
    static Lipstick lipstick = new Lipstick();
    static Mirror mirror = new Mirror();

    // 选择哪个资源
    int choice;
    // 使用者
    String name;

    Makeup(int choice, String name) {
        this.choice = choice;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            makeup();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    // 化妆，互相持有对方的锁，就是需要拿到对方的资源
    private void makeup() throws InterruptedException {
        if (choice == 0) {
            // 获得资源一的锁
            synchronized (lipstick) {
                System.out.println(name + "获得口红");
                Thread.sleep(1000);

                // 获得资源二的锁
//                synchronized (mirror) {
//                    System.out.println(name + "获得镜子");
//                }
            }

            // 解决方法
            synchronized (mirror) {
                System.out.println(name + "获得镜子");
            }
        }

        if (choice == 1) {
            // 获得资源二的锁
            synchronized (mirror) {
                System.out.println(name + "获得镜子");
                Thread.sleep(2000);

                // 获得资源二的锁
//                synchronized (lipstick) {
//                    System.out.println(name + "获得口红");
//                }
            }

            // 解决方法
            synchronized (lipstick) {
                System.out.println(name + "获得口红");
            }
        }
    }
}
