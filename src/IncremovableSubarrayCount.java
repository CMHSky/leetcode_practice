/*
给你一个下标从 0 开始的 正 整数数组 nums 。
如果 nums 的一个子数组满足：移除这个子数组后剩余元素 严格递增 ，那么我们称这个子数组为 移除递增 子数组。比方说，[5, 3, 4, 6, 7] 中的 [3, 4] 是一个移除递增子数组，因为移除该子数组后，[5, 3, 4, 6, 7] 变为 [5, 6, 7] ，是严格递增的。
请你返回 nums 中 移除递增 子数组的总数目。
注意 ，剩余元素为空的数组也视为是递增的。
子数组 指的是一个数组中一段连续的元素序列。

示例 1：

输入：nums = [1,2,3,4]
输出：10
解释：10 个移除递增子数组分别为：[1], [2], [3], [4], [1,2], [2,3], [3,4], [1,2,3], [2,3,4] 和 [1,2,3,4]。移除任意一个子数组后，剩余元素都是递增的。注意，空数组不是移除递增子数组。

示例 2：

输入：nums = [6,5,7,8]
输出：7
解释：7 个移除递增子数组分别为：[5], [6], [5,7], [6,5], [5,7,8], [6,5,7] 和 [6,5,7,8] 。
nums 中只有这 7 个移除递增子数组。

示例 3：

输入：nums = [8,7,6,6]
输出：3
解释：3 个移除递增子数组分别为：[8,7,6], [7,6,6] 和 [8,7,6,6] 。注意 [8,7] 不是移除递增子数组因为移除 [8,7] 后 nums 变为 [6,6] ，它不是严格递增的。

题号：2970
* */

/*
知识点：数组，双指针
* */

public class IncremovableSubarrayCount {
    public int incremovableSubarrayCount(int[] nums) {
        int total = 0;
        for (int left = 0; left < nums.length; left++) {
            int right = left;
            while (right < nums.length) {
                // 检查左边
                boolean lFlag = true;
                int curLeft = -1;
                // 移除子数组的第一个元素如果是数组的第一个元素，直接判定左边递增
                if (left != 0) {
                    // 判定做左子数组严格递增
                    curLeft = nums[0];
                    for (int i = 1; i < left; i++) {
                        if (curLeft >= nums[i]) {
                            lFlag = false;
                            break;
                        }

                        curLeft = nums[i];
                    }
                }

                // 检查右边
                boolean rFlag = true;
                // 移除子数组的最后一个元素如果是数组的最后一个元素，直接判定右边递增
                if (right != nums.length - 1) {
                    int curRight = nums[right + 1];
                    // 右子数组的第一个元素要大于左子数组的最后一个元素
                    if (curRight > curLeft) {
                        // 判定右子数组严格递增
                        for (int i = right + 2; i < nums.length; i++) {
                            if (curRight >= nums[i]) {
                                rFlag = false;
                                break;
                            }

                            curRight = nums[i];
                        }
                    } else {
                        rFlag = false;
                    }
                }

                if (lFlag && rFlag) {
//                    System.out.println("left: " + left + ", right: " + right);
                    total++;
                }

                right++;
            }
        }

        return total;
    }
}
