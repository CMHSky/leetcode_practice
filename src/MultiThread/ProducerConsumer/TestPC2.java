package MultiThread.ProducerConsumer;

/*
* 测试生产者消费者模式：信号灯法，通过标志位解决
* */
public class TestPC2 {
    public static void main(String[] args) {
        Product2 prod = new Product2();

        new Producer2(prod).start();
        new Consumer2(prod).start();
    }
}

// 生产者
class Producer2 extends Thread {
    Product2 prod;

    public Producer2(Product2 prod) {
        this.prod = prod;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            prod.produce(i);
        }
    }
}

// 消费者
class Consumer2 extends Thread {
    Product2 prod;

    public Consumer2(Product2 prod) {
        this.prod = prod;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            prod.consume();
        }
    }
}

// 产品
class Product2 {
    // 资源
    int resource;
    // 标志位
    boolean flag = true;

    // 生产
    public synchronized void produce(int resource) {
        // 如果标志位为真，表示需要生产新的资源
        // 如果标志位为假，表示资源还未被消费
        while (!flag) {
            try {
                // 资源还未被消费，生产者等待
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("生产者生产资源: " + resource);

        // 通知消费者消费
        this.notifyAll();
        this.resource = resource;
        this.flag = !this.flag;
    }

    // 消费
    public synchronized void consume() {
        while (flag) {
            try {
                // 资源还未被生产，消费者等待
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("消费者消费了资源：" + resource);

        // 通知生产者生产
        this.notifyAll();
        this.flag = !this.flag;
    }
}
