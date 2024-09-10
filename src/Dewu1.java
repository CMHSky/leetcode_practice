import java.util.Scanner;

public class Dewu1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        int[][] orders = new int[t][];
        for (int i = 0; i < t; i++) {
            int[] order = new int[3];
            order[0] = in.nextInt();
            order[1] = in.nextInt();
            order[2] = in.nextInt();
            orders[i] = order;
        }

        for (int[] order : orders) {
            int n = order[0];
            int l = order[1];
            int r = order[2];

            int min = l % n == 0 ? l / n : l / n + 1;
            int max = r / n;

            if (min <= max) {
                System.out.println(min + " " + max);
            } else {
                System.out.println(-1);
            }
        }
    }
}
