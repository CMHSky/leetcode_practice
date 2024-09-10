/**
* 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。

 * 示例 1:
 * 输入: [3,2,1,5,6,4], k = 2
 * 输出: 5

 * 示例 2:
 * 输入: [3,2,3,1,2,4,5,5,6], k = 4
 * 输出: 4

 * 题号：215
 * 知识点：堆
* */

public class TopK {
    public int findKthLargest(int[] nums, int k) {
        int heapSize = nums.length;
        // 建立大顶堆
        buildMaxHeap(nums, heapSize);

        // k = 1 时，top-1 为 nums[0]
        // k >= 2 时，删除根节点（根节点与最后一个节点换位，并且堆大小 - 1），然后以num[0]为根节点，重新构建大顶堆
        for (int i = nums.length - 1; i >= nums.length - k + 1; i--) {
            swap(nums, 0, i);
            heapify(nums, 0, --heapSize);
        }

        // 堆排序
//        for (int i = nums.length - 1; i > 0; i--) {
//            swap(nums, 0, i);
//            heapify(nums, 0, i);
//        }

        return nums[0];
    }

    private void buildMaxHeap(int[] nums, int heapSize) {
        // 遍历有子节点的节点，并且对对应子树进行递归堆化
        for (int i = heapSize / 2 - 1; i >= 0; i--) {
            heapify(nums, i, heapSize);
        }
    }

    // 堆化函数
    private void heapify(int[] nums, int i, int heapSize) {
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        int largest = i;

        // 如果存在左子节点，并且左子节点的值大于子树根节点
        if (left < heapSize && nums[left] > nums[largest]) {
            largest = left;
        }

        // 如果存在右子节点，并且右子节点的值大于子树根节点
        if (right < heapSize && nums[right] > nums[largest]) {
            largest = right;
        }

        // 换位
        if (largest != i) {
            swap(nums, i, largest);
//            System.out.println("i = " + i + " n = " + heapSize);
//            System.out.println(Arrays.toString(nums));
            heapify(nums, largest, heapSize);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
