/*
给你一个整数数组 nums。

返回两个（不一定不同的）质数在 nums 中 下标 的 最大距离。

示例 1：

输入： nums = [4,2,9,5,3]

输出： 3

解释： nums[1]、nums[3] 和 nums[4] 是质数。因此答案是 |4 - 1| = 3。

示例 2：

输入： nums = [4,8,2,8]

输出： 0

解释： nums[2] 是质数。因为只有一个质数，所以答案是 |2 - 2| = 0。

提示：

1 <= nums.length <= 3 * 105
1 <= nums[i] <= 100
输入保证 nums 中至少有一个质数。
* */


public class MaxPrimeDifference {
    int firstIndex = -1, lastIndex = -1;
    public int maximumPrimeDifference(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (isPrimeV2(nums[i])) {
                if (this.firstIndex == -1 && this.lastIndex == -1) {
                    this.firstIndex = i;
                }

                this.lastIndex = i;
            }
        }

        return this.lastIndex - this.firstIndex;
    }

    // 判断素数
    // 解法一：暴力求解
    // 时间：31ms
    private boolean isPrime(int num) {
        if (num == 1) {
            return false;
        }

        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    // 解法二：利用素数性质求解
    // 时间：12ms
    private boolean isPrimeV2(int num) {
        // 性质一：1不是素数
        if (num == 1) return false;

        // 性质二：2，3，5，7是素数
        if (num == 2 || num == 3 || num == 5 || num == 7) return true;

        // 性质三：个位数是1，3，7，9，且不能被2，3，5，7整除的数是素数
        int ld = num % 10;
        if (ld == 1 || ld == 3 || ld == 7 || ld == 9) {
            return num % 2 != 0 && num % 3 != 0 && num % 5 != 0 && num % 7 != 0;
        }

        return false;
    }
}
