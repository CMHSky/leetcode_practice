/*
给你两个下标从 0 开始的整数数组 nums1 和 nums2 ，它们分别含有 n 和 m 个元素。请你计算以下两个数值：

answer1：使得 nums1[i] 在 nums2 中出现的下标 i 的数量。
answer2：使得 nums2[i] 在 nums1 中出现的下标 i 的数量。
返回 [answer1, answer2]。

示例 1：

输入：nums1 = [2,3,2], nums2 = [1,2]
输出：[2,1]

示例 2：

输入：nums1 = [4,3,2,3,1], nums2 = [2,2,5,2,3,6]
输出：[3,4]

nums1 中下标在 1，2，3 的元素在 nums2 中也存在。所以 answer1 为 3。
nums2 中下标在 0，1，3，4 的元素在 nums1 中也存在。所以 answer2 为 4。

示例 3：
输入：nums1 = [3,4,2,3], nums2 = [1,5]
输出：[,0]

nums1 和 nums2 中没有相同的数字，所以答案是 [0,0]。

题号：2956
* */

/*
* 知识点：数组，Set，Map
* */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindIntersectionValues {

    // 解法一：Map
    // 速度慢，内存消耗高
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();

        for (int num : nums1) {
            map1.merge(num, 1, Integer::sum);
        }

        int ans2 = 0;
        for (int num : nums2) {
            map2.merge(num, 1, Integer::sum);
            if (map1.get(num) != null) {
                ans2++;
            }
        }

        int ans1 = 0;
        for (int key : map1.keySet()) {
            if (map2.get(key) != null) {
                ans1 += map1.get(key);
            }
        }

        int[] result = new int[2];
        result[0] = ans1;
        result[1] = ans2;
        return result;
    }

    // 解法二：Set
    // 速度一般，但是内存消耗低
    public int[] findIntersectionValuesV2(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int num : nums1) {
            set1.add(num);
        }

        int ans2 = 0;
        for (int num: nums2) {
            set2.add(num);
            if (set1.contains(num)) {
                ans2++;
            }
        }

        int ans1 = 0;
        for (int num : nums1) {
            if (set2.contains(num)) {
                ans1++;
            }
        }

        int[] result = new int[2];
        result[0] = ans1;
        result[1] = ans2;
        return result;
    }

    // 解法三：遍历数组
    // 速度最快，但是内存消耗较高
    public int[] findIntersectionValuesV3(int[] nums1, int[] nums2) {
        int ans1 = 0;
        for (int num1 : nums1) {
            for (int num2 : nums2) {
                if (num1 == num2) {
                    ans1++;
                    break;
                }
            }
        }

        int ans2 = 0;
        for (int num2 : nums2) {
            for (int num1 : nums1) {
                if (num2 == num1) {
                    ans2++;
                    break;
                }
            }
        }

        int[] result = new int[2];
        result[0] = ans1;
        result[1] = ans2;
        return result;
    }
}
