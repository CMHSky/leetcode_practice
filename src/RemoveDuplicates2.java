/*
给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。

不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。

示例 1：

输入：nums = [1,1,1,2,2,3]
输出：5, nums = [1,1,2,2,3]
解释：函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3。 不需要考虑数组中超出新长度后面的元素。

示例 2：

输入：nums = [0,0,1,1,1,1,2,3,3]
输出：7, nums = [0,0,1,1,2,3,3]
解释：函数应返回新长度 length = 7, 并且原数组的前七个元素被修改为 0, 0, 1, 1, 2, 3, 3。不需要考虑数组中超出新长度后面的元素。
* */

/*
* 知识点：双指针，快慢指针
* */

public class RemoveDuplicates2 {
    public int removeDuplicates(int[] nums) {
        int fast = 1;
        int slow = 0;
        int frequency = 1;

        while (fast < nums.length) {
            if (nums[slow] == nums[fast]) {
                if (frequency < 2) {
                    nums[++slow] = nums[fast++];

                    frequency++;
                } else {
                    fast++;
                }
            } else {
                nums[++slow] = nums[fast++];
                frequency = 1;
            }
        }

        return slow + 1;
    }
}
