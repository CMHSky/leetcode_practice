/**
* 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。

 * 示例 1：
 * 输入：head = [1,2,3,3,4,4,5]
 * 输出：[1,2,5]

 * 示例 2：
 * 输入：head = [1,1,1,2,3]
 * 输出：[2,3]

 * 题号：82

 * 知识点：链表
* */

public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode cur = head;
        ListNode pre = null;
        ListNode p = head;

        while (p.next != null) {
            int count = 0;
            boolean hasNext = false;
            while (p.next != null) {
                p = p.next;
                if (cur.val != p.val) {
                    hasNext = true;
                    break;
                }

                count++;
            }

            // 无重复
            if (count == 0) {
                pre = cur;
                cur = p;
            } else {
                // 有重复
                // 1. 开始就有重复 [1, 1, 1, 3, 4]
                if (pre == null) {
                    // 特殊情况：到达了最后一个node
                    if (p.next == null) {
                        // 最后一个node是不同数字 [1, 1, 1, 2]
                        if (hasNext) {
                            return p;
                        } else {
                            // 最后一个node是相同数字 [1, 1, 1]
                            return null;
                        }
                    }

                    head = p;
                } else {
                    // 有前置的不重复的节点 [1, 2, 3, 3, 5, 6]
                    // 特殊情况，到达了最后一个node
                    if (p.next == null) {
                        // 最后一个node是不同数字 [1, 2, 3, 3, 5]
                        if (hasNext) {
                            pre.next = p;
                        } else {
                            // 最后一个node是相同数字 [1, 2, 3, 3, 3]
                            pre.next = null;
                        }

                        return head;
                    }

                    pre.next = p;
                }

                cur = p;
            }
        }

        return head;
    }
}