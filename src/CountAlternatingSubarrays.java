/*
给你一个二进制数组nums 。
如果一个子数组中 不存在 两个 相邻 元素的值 相同 的情况，我们称这样的子数组为 交替子数组 。
返回数组 nums 中交替子数组的数量。

示例 1：

输入： nums = [0,1,1,1]

输出： 5

解释：

以下子数组是交替子数组：[0] 、[1] 、[1] 、[1] 以及 [0,1] 。

示例 2：

输入： nums = [1,0,1,0]

输出： 10

解释：

数组的每个子数组都是交替子数组。可以统计在内的子数组共有 10 个。

题号：3101
* */
/*
* 知识点：双指针
* */


public class CountAlternatingSubarrays {
    public long countAlternatingSubarrays(int[] nums) {
        // 使用双指针来标记子数组的头尾
        // 性质一：k长度的交替数组，子数组的数量为 1+2+3+...+k 个
        long count = 0;
        long start = 0;
        long end = 0;
        // 使用一个变量来记录上一个元素的值
        int last = 0;
        for (int element : nums) {
            // 初始情况：start和end都指向第一个元素，count加1，并且end向后移一位
            if (start == end) {
                count++;
                end++;
                last = element;
                continue;
            }

            // 情况一：前后元素不同值，即start到end长度的子数组为交替数组
            if (last != element) {
                count += (++end - start);
            } else {
                // 情况二：前后元素同值，更新start的值，重新记录后续的交替子数组
                count++;
                start = end++;
            }

            last = element;
        }

        return count;
    }
}
