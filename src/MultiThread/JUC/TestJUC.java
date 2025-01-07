package MultiThread.JUC;

import java.util.concurrent.CopyOnWriteArrayList;

/*
* 测试JUC安全类型的集合
* 1. CopyOnWriteArrayList
* 2. CopyOnWriteArraySet
* 3. ConcurrentHashMap
* 4. ConcurrentLinkedQueue
* 5. ConcurrentLinkedDeque
* 6. ConcurrentSkipListMap
* 7. ConcurrentSkipListSet
* */
public class TestJUC {
    public static void main(String[] args) {
        // 线程安全的ArrayList
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();

        // 10000个线程同时往list中添加数据
        for (int i = 0; i < 10000; i++) {
            new Thread(() -> {
                list.add(Thread.currentThread().getName());
            }).start();
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(list.size());
    }
}
