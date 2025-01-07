package MultiThread.Synchronized;

import java.util.ArrayList;
import java.util.List;

/*
* 线程不安全的集合
* 1. ArrayList
* 2. LinkedList
* 3. PriorityQueue
* 4. HashMap
* 5. Hashtable
* 6. HashSet
* 7. Stack
* */
public class UnsafeList {
    public static void main(String[] args) throws InterruptedException {
        // ArrayList线程不安全
        // 多线程情况下，两个线程将数据添加到了ArrayList的同一个位置
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            new Thread(() -> {
                synchronized (list) {
                    list.add(Thread.currentThread().getName());
                }
            }).start();
        }

        Thread.sleep(3000);
        System.out.println(list.size());
    }
}
