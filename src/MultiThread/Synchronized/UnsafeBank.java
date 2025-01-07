package MultiThread.Synchronized;

/*
* 不安全的取钱场景
* 两个人去银行取钱，同一个账户
* */
/*
* 同步块 synchronized(Obj) { }
* Obj 称之为同步检查器
* 1. Obj 可以是任何对象，但是推荐使用共享资源作为同步监视器
* 2. 同步方法中无需指定同步监视器，因为同步方法的同步监视器就是this，就是这个对象本身，或者是class
*
* 同步监视器的执行过程
* 1. 第一个线程访问，锁定同步监视器，执行其中代码
* 2. 第二个线程访问，发现同步监视器被锁定，无法访问
* 3. 第一个线程执行完毕，解锁同步监视器
* 4. 第二个线程访问，发现同步监视器没有被锁定，锁定并执行其中代码
* */

/*
* 锁的粒度：
* 对于同步代码块，锁是synchronized括号里配置的对象
* */

// TODO 余额会变为负数
public class UnsafeBank {
    public static void main(String[] args) {
        Account account = new Account(100, "结婚基金");

        Drawing you = new Drawing(account, 50, "你");
        Drawing girlFriend = new Drawing(account, 100, "女朋友");

        you.start();
        girlFriend.start();
    }
}

// 账户
// 需要被锁定的对象
// TODO TO BE LOCKED
class Account {
    int money;
    String name;

    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }
}

// 银行：模拟取款
// synchronized修饰成员方法，默认锁的是this
class Drawing extends Thread {
    // 模拟账户
    Account account;
    // 取了多少钱
    int drawingMoney;
    // 现在手里有多少钱
    int nowMoney;

    public Drawing(Account account, int drawingMoney, String name) {
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;
    }

    @Override
    public void run() {
        // 锁定同步监视器，在同步块中监视account对象
        // 锁的对象就是变化的量，需要增删改的对象
        synchronized (account) {
            // 判断有没有钱
            if (account.money - drawingMoney < 0) {
                System.out.println(Thread.currentThread().getName() + "钱不够，取款失败");
                return;
            }

            // 模拟延时，放大问题的发生性
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            // 卡内余额 = 余额 - 取的钱
            account.money = account.money - drawingMoney;
            // 手里的钱 = 手里的钱 + 取的钱
            nowMoney += drawingMoney;

            System.out.println(account.name + "取款成功，余额为：" + account.money);
            System.out.println(this.getName() + "手里的钱为：" + nowMoney);
        }
    }
}


