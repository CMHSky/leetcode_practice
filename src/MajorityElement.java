/*
给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。

你可以假设数组是非空的，并且给定的数组总是存在多数元素。

示例 1：

输入：nums = [3,2,3]
输出：3
示例 2：

输入：nums = [2,2,1,1,1,2,2]
输出：2

题号：169
* */

/*
* 知识点：数组
* */

public class MajorityElement {
    public int majorityElement(int[] nums) {
        int half = nums.length % 2 == 0 ? nums.length/2: nums.length/2 + 1;
        int a = nums[0];
        int b = nums[0];
        int numA = 0;
        int numB = 0;
        for (int num: nums) {
            if (num == a)
                numA++;
            else {
                b = num;
                numB++;
            }

            if (numA == half) {
                return a;
            }

            if (numB == half) {
                return b;
            }
        }

        return numA >= numB? a: b;
    }
}
