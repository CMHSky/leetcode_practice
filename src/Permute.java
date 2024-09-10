import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。

 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

 * 示例 2：
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]

 * 示例 3：
 * 输入：nums = [1]
 * 输出：[[1]]

 * 题号：46
 * 知识点：回溯 或 BFS
 * */

public class Permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        // 遍历数组，当前元素为排列的第一个元素
        for (int i = 0; i < nums.length; i++) {
            List<Integer> output = new ArrayList<>();
            output.add(nums[i]);

            List<Integer> rest = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    rest.add(nums[j]);
                }
            }

            bfs(result, output, rest);
        }

        return result;
    }

    // 使用BFS找出所有排列结果
    // e.g [1, 2, 3]
    // 1. output: [1] rest: [2, 3]
    // 1.1. output: [1, 2] rest: [3]
    // 1.2. output: [1, 3] rest: [2]
    // 1.1.1 output: [1, 2, 3] rest: []
    // 1.2.1 output: [1, 3 ,2] rest: []

    // 2. output: [2] rest: [1, 3]
    // 2.1. output: [2, 1] rest: [3]
    // 2.2. output: [2, 3] rest: [1]
    // 2.1.1. output: [2, 1, 3] rest: []
    // 2.2.1. output: [2, 3, 1] rest: []

    // 3. output: [3] rest: [1, 2]
    // 3.1. output: [3, 1] rest: [2]
    // 3.2. output: [3, 2] rest: [1]
    // 3.1.1. output: [3, 1, 2] rest: []
    // 3.2.1. output: [3, 2, 1] rest: []

    // 缺点：内存消耗大，大量使用了List的浅拷贝
    private void bfs(List<List<Integer>> res, List<Integer> output, List<Integer> rest) {
        if (rest.isEmpty()) {
            res.add(output);
            return;
        }

        for (int i = 0; i < rest.size(); i++) {
            List<Integer> newOutput = new ArrayList<>(output);
            newOutput.add(rest.get(i));

            List<Integer> newRest = new ArrayList<>(rest);
            newRest.remove(i);

            bfs(res, newOutput, newRest);
        }
    }
}
