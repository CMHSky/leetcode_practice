/**
* 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * 找出该数组中满足其总和大于等于 target 的长度最小的
 * 子数组[numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。

 * 示例 1：
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。

 * 示例 2：
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1

 * 示例 3：
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0

 * 题号：209

 * 知识点：滑动窗口
* */

public class MinSubArrayLen {
    public int minSubArrayLen(int target, int[] nums) {
        int start = 0;
        int end = 0;
        int result = Integer.MAX_VALUE;
        int sum = 0;
        while (end < nums.length) {
            sum += nums[end];
            while (sum >= target) {
                result = Math.min(result, end - start + 1);
                sum -= nums[start];
                start++;
            }

            end++;
        }

        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
