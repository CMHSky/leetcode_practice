/**
 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
 实现 LRUCache 类：
 LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。

 示例：

 输入
 ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 输出
 [null, null, null, 1, null, -1, null, -1, 3, 4]

 解释
 LRUCache lRUCache = new LRUCache(2);
 lRUCache.put(1, 1); // 缓存是 {1=1}
 lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
 lRUCache.get(1);    // 返回 1
 lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
 lRUCache.get(2);    // 返回 -1 (未找到)
 lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
 lRUCache.get(1);    // 返回 -1 (未找到)
 lRUCache.get(3);    // 返回 3
 lRUCache.get(4);    // 返回 4

 题号：146
* */

/*
* 知识点：链表，哈希表
* */

import java.util.HashMap;
import java.util.Map;

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

/*
* 思路：使用一个哈希表作为cache的载体，存储元素，以达到查找的时间复杂度为 O(1)
* 使用一个双向链表来维护cache中元素的最近使用情况，越不经常使用的元素越靠后
* */

public class LRUCache {
    // 定义一个hash表，<key, node>，用于存储key，以及其对应的双向链表中的节点地址
    private final Map<Integer, DLinkedNode> cache = new HashMap<>();
    // 双向链表的伪头部
    private final DLinkedNode head;
    // 双向链表的伪尾部
    private final DLinkedNode tail;
    // cache的容量
    private final int capacity;
    // 当前cache的元素数量
    private int size;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;

        // 创建双向链表的伪头部和伪尾部
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }

        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        // cache中不存在该元素，添加新元素
        if (node == null) {
            // 新建节点
            DLinkedNode newNode =  new DLinkedNode(key, value);
            cache.put(key, newNode);
            // 将节点置于双向链表头部
            addToHead(newNode);
            size++;

            // 如果链表的长度超过了cache的容量
            if (size > capacity) {
                // 删除双向链表的尾部元素（最不常访问的元素）
                DLinkedNode tail = removeTail();
                // 在cache中删除该元素
                cache.remove(tail.key);
                size--;
            }
        } else {
            // 该元素存在，修改已有元素的值
            node.value = value;
            // 该元素被访问，将其节点置于双向链表头部
            moveToHead(node);
        }
    }

    // 对双向链表的操作
    // 将新节点添加至双向链表的头部
    // 作用：当添加一个新元素时，直接将该元素置于双向链表头部，即标记该元素为最近最常使用
    private void addToHead(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    // 删除指定节点
    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // 将已存在的节点移到链表头部
    // 作用：当一个已存在的元素最近刚刚被使用时，将其置于双向链表头部，即标记该元素为最近最常使用
    // 1. cache查询
    // 2. 修改已存在元素的value
    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    // 删除尾部节点
    // 作用：当cache的满容量时，用于删除cache中最不经常使用的元素
    private DLinkedNode removeTail() {
        DLinkedNode node = tail.prev;
        removeNode(node);
        return node;
    }
}

class DLinkedNode {
    int key;
    int value;
    DLinkedNode prev;
    DLinkedNode next;
    public DLinkedNode() {}
    public DLinkedNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}


