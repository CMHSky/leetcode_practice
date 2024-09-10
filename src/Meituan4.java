import java.util.Map;
import java.util.Scanner;
import java.util.PriorityQueue;

public class Meituan4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }

        int result = minimizeRange(nums);
        System.out.println(result);
    }

    private static int minimizeRange(int[] nums) {
        int ops;

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        int avg = sum / nums.length;

        int diff = 0;
        for (int num : nums) {
            diff += Math.abs(avg - num);
        }

        ops = diff % 2 == 0 ? diff / 2 : diff / 2 + 1;

        return ops;
    }
}
