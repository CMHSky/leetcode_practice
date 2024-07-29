/*
峰值元素是指其值严格大于左右相邻值的元素。
给你一个整数数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
你可以假设 nums[-1] = nums[n] = -∞ 。
你必须实现时间复杂度为 O(log n) 的算法来解决此问题。

示例 1：

输入：nums = [1,2,3,1]
输出：2
解释：3 是峰值元素，你的函数应该返回其索引 2。

示例 2：
输入：nums = [1,2,1,3,5,6,4]
输出：1 或 5
解释：你的函数可以返回索引 1，其峰值元素为 2；
     或者返回索引 5， 其峰值元素为 6。

题号：162
* */

/*
* 知识点：二分查找
* */

public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }

        return find(nums, 0, nums.length - 1, nums.length / 2);
    }

    private int find(int[] nums, int start, int end, int index) {
        if (start > end) {
            return -1;
        }

        if (index == 0) {
            if (nums[index] > nums[index+1]) return index;
        } else if (index == nums.length - 1) {
            if (nums[index] > nums[index-1]) return index;
        } else {
            if (nums[index] > nums[index-1] && nums[index] > nums[index+1]) return index;
        }

        int left = find(nums, start, index - 1, (start+index-1)/2);
        if (left != -1) {
            return left;
        }

        return find(nums, index + 1, end, (index+1+end)/2);
    }
}
