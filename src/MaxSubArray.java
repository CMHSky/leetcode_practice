/**
* 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

 * 子数组
 * 是数组中的一个连续部分。

 * 示例 1：
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。

 * 示例 2：
 * 输入：nums = [1]
 * 输出：1

 * 示例 3：
 * 输入：nums = [5,4,-1,7,8]
 * 输出：23

 * 题号：53

 * 知识点：动态规划
* */

public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int pre = 0;
        int res = nums[0];

        for (int num : nums) {
            pre = Math.max(pre + num, num);
            res = Math.max(res, pre);
        }

        return res;
    }
}
