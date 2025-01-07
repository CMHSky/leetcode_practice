package MultiThread.ProducerConsumer;

/*
* 测试生产者消费者模型 --> 利用缓冲区解决（管程法）
* */
public class TestPC {
    public static void main(String[] args) {
        SynContainer synContainer = new SynContainer();

        new Producer(synContainer).start();
        new Consumer(synContainer).start();
    }
}

// 生产者
class Producer extends Thread {
    SynContainer container;

    public Producer(SynContainer container) {
        this.container = container;
    }

    // 生产产品
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("生产了第" + container.push(new Chicken(i)).id + "只鸡");
        }
    }
}

// 消费者
class Consumer extends Thread {
    SynContainer container;

    public Consumer(SynContainer container) {
        this.container = container;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("消费了第" + container.pop().id + "只鸡");
        }
    }
}

// 定义产品
class Chicken {
    // 产品编号
    int id;

    public Chicken(int id) {
        this.id = id;
    }
}

// 缓冲区
class SynContainer {
    // 容器大小
    Chicken[] chickens = new Chicken[10];
    // 容器计数器
    int count = 0;

    // 生产者放入产品
    public synchronized Chicken push(Chicken chicken) {
        // 如果容器满了，就需要等待消费者消费
        while (count == chickens.length) {
            // 通知消费者消费
            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        // 如果容器没满，就可以生产
        chickens[count] = chicken;
        count++;

        // 通知消费者消费
        this.notifyAll();

        return chicken;
    }

    // 消费者消费产品
    public synchronized Chicken pop() {
        // 如果容器没产品，就需要等待生产者生产
        while (count == 0) {
            // 通知生产者生产，消费者等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        // 如果容器有产品，就可以消费
        count--;
        Chicken chicken = chickens[count];

        // 通知生产者生产
        this.notifyAll();

        return chicken;
    }
}