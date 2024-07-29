/*
给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。

子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。

示例 1：
输入：nums = [10,9,2,5,3,7,101,18]
输出：4
解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。

示例 2：
输入：nums = [0,1,0,3,2,3]
输出：4

示例 3：
输入：nums = [7,7,7,7,7,7,7]
输出：1

题号：300
* */

/*
* 知识点：动态规划
* */

public class LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        // 维护一个与原数组同样长度的数组
        // 存储以第i个元素结尾时，最长的严格递增子数组的长度
        int[] dp = new int[nums.length];
        int max = 1;

        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            int len = 1;
            for (int j = 0; j <= i; j++) {
                if (nums[j] < nums[i]) {
                    // 当有元素比当前第i位的元素小的时候，加上第i位元素，长度则为dp[j] + 1
                    len = Math.max(len, dp[j] + 1);
                }
            }

            dp[i] = len;
            max = Math.max(max, len);
        }

        return max;
    }
}
