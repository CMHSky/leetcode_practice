/*
给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。

请你设计并实现时间复杂度为 O(n) 的算法解决此问题。

示例 1：

输入：nums = [100,4,200,1,3,2]
输出：4
解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。

示例 2：

输入：nums = [0,3,7,2,5,8,4,6,0,1]
输出：9

题号：128
* */

/*
* 知识点：哈希表，Set
* */

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        // 使用HashSet去重，并提高查找效率
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int cur = 1;
        int longest = 1;
        for (int num : set) {
            int p = num + 1;
            // 如果当前数字的前一个数字在集合中，则跳过该数字
            if (set.contains(num - 1)) {
                continue;
            }

            // 当该数字为序列的第一个数字时，检查其后续数字是否在集合中，更新最长序列长度
            while (set.contains(p)) {
                cur++;
                p++;
            }

            longest = Math.max(cur, longest);
            cur = 1;
        }

        return longest;
    }
}
