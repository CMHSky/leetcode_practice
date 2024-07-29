/*
给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。

示例 1：
输入：head = [1,2,3,4,5], k = 2
输出：[4,5,1,2,3]

示例 2：
输入：head = [0,1,2], k = 4
输出：[2,0,1]

题号：61
* */

/*
* 知识点：链表
* */

public class RotateRight {
    public ListNode rotateRight(ListNode head, int k) {
        // 处理特殊情况
        if (head == null || k == 0) {
            return head;
        }

        // 找到尾节点，并将收尾相连
        ListNode p = head;
        int len = 1;
        while (p.next != null) {
            len++;
            p = p.next;
        }

        p.next = head;
        k = k % len;

        // 找到新的头节点的前置节点
        p = head;
        for (int i = 1; i < len - k; i++) {
            p = p.next;
        }

        head = p.next;
        p.next = null;

        return head;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

