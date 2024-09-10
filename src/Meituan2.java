import java.util.Scanner;

public class Meituan2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        int[][] infos = new int[n][3];
        int[][] numsArray = new int[n][];

        for (int i = 0; i < n; i++) {
            String[] info = in.nextLine().split(" ");
            for (int j = 0; j < 3; j++) {
                infos[i][j] = Integer.parseInt(info[j]);
            }

            String[] nums = in.nextLine().split(" ");
            numsArray[i] = new int[infos[i][0]];
            for (int j = 0; j < infos[i][0]; j++) {
                numsArray[i][j] = Integer.parseInt(nums[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println(computeMin(infos[i], numsArray[i]));
        }
    }

    private static int computeMin(int[] info, int[] nums) {
        int[] currentNums = new int[nums.length];
        System.arraycopy(nums, 0, currentNums, 0, nums.length);

        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i <= nums.length; i++) {
            int cost = 0;
            for (int j = 0; j < i; j++) {
                int[] newNums = new int[currentNums.length - 1];
                System.arraycopy(currentNums, 1, newNums, 0, newNums.length);
                currentNums = newNums;
                cost += info[2];
            }

            cost += cleanAll(info, currentNums);
            minCost = Math.min(minCost, cost);
        }

        return minCost;
    }

    private static int cleanAll(int[] info, int[] nums) {
        int minInt = minInt(nums);
        return info[1] * minInt;
    }

    private static int minInt(int[] nums) {
        int n = nums.length;
        boolean[] present = new boolean[n + 1];

        for (int num : nums) {
            if (num > 0 && num <= n) {
                present[num] = true;
            }
        }

        for (int i = 0; i < n; i++) {
            if (!present[i]) {
                return i;
            }
        }

        return n + 1;
    }
}
