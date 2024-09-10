/**
 * 排序算法汇总
* */
public class Sort {

    /**
    * 冒泡排序
     * 原理：反复地遍历要排序的列表，每次比较相邻的两个元素，如果它们的顺序错误就交换它们的位置。
     * 最佳情况：O(n)
     * 平均情况：O(n ^ 2)
     * 最坏情况：O(n ^ 2)
    * */
    public void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                }
            }
        }
    }

    /**
    * 选择排序
     * 原理：将列表分为已排序和未排序两个部分，反复从未排序部分中选择最小(或最大)的元素，放到已排序部分的末尾。
     * 最佳情况：O(n ^ 2)
     * 平均情况：O(n ^ 2)
     * 最坏情况：O(n ^ 2)
    * */
    public void selectionSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }

            swap(nums, i, minIndex);
        }
    }

    /**
    * 插入排序
     * 原理：将列表分成已排序和未排序两部分，反复从未排序部分中取出第一个元素，将其插入到已排序部分的适当位置。
     * 最佳情况：O(n)
     * 平均情况：O(n ^ 2)
     * 最坏情况：O(n ^ 2)
    * */
    public void insertionSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int key = nums[i];
            int j = i - 1;
            // 倒序遍历已排序数组，寻找合适的插入位置
            while (j >=0 && nums[j] > key) {
                nums[j + 1] = nums[j];
                j--;
            }

            nums[j + 1] = key;
        }
    }

    /**
    * 快速排序
     * 原理：选择一个基准元素，将列表分成子列表，所有比基准小的元素放在基准前面，所有比基准大的元素放在基准后面，然后递归地对两个子列表进行排序。
     * 最佳情况：O(n log n)
     * 平均情况：O(n log n)
     * 最坏情况：O(n ^ 2)
    * */
    public void quickSort(int[] nums) {
        quick(nums, 0, nums.length - 1);
    }

    private void quick(int[] nums, int low, int high) {
        if (low < high) {
            int pivot = partition(nums, low, high);
            quick(nums, low, pivot - 1);
            quick(nums, pivot + 1, high);
        }

    }

    private int partition(int[] nums, int low, int high) {
        int pivot = nums[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (nums[j] < pivot) {
                i++;

                if (i != j) {
                    swap(nums, i, j);
                }
            }
        }

        // 将基准元素和右子数组的第一个元素互换，使得左子数组都小于基准元素，右子数组都大于等于基准元素
        swap(nums, i + 1, high);
        return i + 1;
    }

    /**
    * 归并排序
     * 原理：将数组分成两个子数组，分别对其进行排序，然后将两个已排列的子数组合并成一个有序数组。
     * 最佳情况：O(n log n)
     * 平均情况：O(n log n)
     * 最坏情况：O(n log n)
    * */
    public void mergeSort(int[] nums) {
        innerMergeSort(nums, 0, nums.length - 1);
    }

    private void innerMergeSort(int[] nums, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            innerMergeSort(nums, left, mid);
            innerMergeSort(nums, mid + 1, right);
            merge(nums, left, mid, right);
        }
    }

    private void merge(int[] nums, int left, int mid, int right) {
        int[] mergedNums = new int[right - left + 1];
        // 左子数组指针
        int i = left;
        // 右子数组指针
        int j = mid + 1;
        int k = 0;

        // 此时用于合并的两个子数组是有序的
        // 先比较两个数组元素大小，直到一个数组中的元素全部进入新数组
        while (i <= mid && j <= right) {
            if (nums[i] < nums[j]) {
                mergedNums[k++] = nums[i++];
            } else {
                mergedNums[k++] = nums[j++];
            }
        }

        // 插入左子数组中剩余的元素
        while (i <= mid) {
            mergedNums[k++] = nums[i++];
        }

        // 插入右子数组中剩余的元素
        while (j <= right) {
            mergedNums[k++] = nums[j++];
        }

        // 将排序好的子数组拷贝进原数组
        k = 0;
        for (i = left; i <= right; i++) {
            nums[i] = mergedNums[k++];
        }
    }

    /**
    * 堆排序
     * 原理：构建一个大顶堆，然后将堆顶元素与最后一个元素交换位置，重新调整堆，直到所有元素有序。
     * 最佳情况：O(n log n)
     * 平均情况：O(n log n)
     * 最坏情况：O(n log n)
    * */
    public void heapSort(int[] nums) {
        int heapSize = nums.length;
        // 建立大顶堆
        buildMaxHeap(nums, heapSize);

        // 将最大的元素交换到数组末尾，并且堆大小-1，然后重新对根节点堆化
        for (int i = nums.length - 1; i > 0; i--) {
            swap(nums, 0, i);
            heapify(nums, 0, i);
        }
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
            heapify(nums, largest, heapSize);
        }
    }

    /**
    * 希尔排序
     * 原理：希尔排序是插入排序的一种改进，通过比较相隔一定间隔的元素，并逐渐缩小间隔进行排序。
     * 最佳情况：O(n log n)
     * 平均情况：O(n log2 n)
     * 最坏情况：O(n ^ 2)
    * */
    public void shellSort(int[] nums) {
        int gap = nums.length;

        // 每次按照间隔执行插入排序
        while (gap > 1) {
            gap /= 2;
            shell(nums, gap);
        }
    }

    private void shell(int[] nums, int gap) {
        for (int i = gap; i < nums.length; i++) {
            int temp = nums[i];
            int j = i - gap;

            while (j >= 0) {
                if (nums[j] > temp) {
                    // 如果前一个gap的值小于当前值，前一个gap的值后移一个gap
                    nums[j + gap] = nums[j];
                    j -= gap;
                } else {
                    break;
                }
            }

            // 当前值插入到指定位置
            nums[j + gap] = temp;
        }
    }

    /**
    * 桶排序
     * 原理：桶排序是一种基于分配的排序算法，适用于均匀分布的输入。它的基本思想是将数据分到若干个桶中，然后对每个桶分别进行排序，最后将所有桶中的数据合并起来。
     * 最佳情况：O(n + k)
     * 平均情况：O(n + k)
     * 最坏情况：O(n ^ 2) （取决于桶内排序算法）
    * */
    public void bucketSort(float[] nums) {
        // TODO
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
