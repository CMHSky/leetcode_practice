/*
给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。

判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。

示例 1：

输入：nums = [2,3,1,1,4]
输出：true
解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。

示例 2：

输入：nums = [3,2,1,0,4]
输出：false
解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。

题号：55
* */

/*
* 知识点：贪心算法
* */

public class CanJump {
    public boolean canJump(int[] nums) {
//        return jump(nums, 0, nums.length - 1);

        // 贪心算法
        // 遍历数组，记录当前可以到达的最远距离
        int maxJump = 0;
        // 每次循环更新最远距离，即扩展右边界
        for (int i = 0; i <= maxJump; i++) {
            maxJump = Math.max(maxJump, i + nums[i]);

            // 如果有边界大于等于终点，即可达
            if (maxJump >= nums.length - 1) return true;
        }

        return false;
    }

//    DFS
//    private boolean jump(int[] nums, int cur, int target) {
//        if (target == 0) return true;
//
//        for (int i = 1; i <= nums[cur]; i++) {
//            // 如果到达了目标，返回true
//            if (cur + i == target) return true;
//
//            // 如果没有越界，进行下一次jump
//            if (cur + i < target && jump(nums, cur + i, target)) return true;
//        }
//
//        return false;
//    }
}
