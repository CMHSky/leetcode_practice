import java.util.Scanner;

public class OPPO1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] data = new int[n][];

        for (int i = 0; i < n; i++) {
            int[] unit = new int[3];
            unit[0] = in.nextInt();
            unit[1] = in.nextInt();
            unit[2] = in.nextInt();
            data[i] = unit;
        }

        boolean has = false;
        for (int i = 0; i < data.length; i++) {
            boolean flag = true;
            for (int j = 0; j < data.length; j++) {
                if (i == j) {
                    continue;
                }

                if (!isContains(data[i], data[j]) || !isSeparate(data[i], data[j])) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                System.out.println(i + 1);
                has = true;
                break;
            }
        }

        if (!has) {
            System.out.println(-1);
        }
    }

    private static boolean isContains(int[] a, int[] b) {
        return Math.abs(a[2] - b[2]) > Math.sqrt(Math.pow(a[0] - b[0], 2) + Math.pow(a[1] - b[1], 2));
    }

    private static boolean isSeparate(int[] a, int[] b) {
        return a[2] + b[2] > Math.sqrt(Math.pow(a[0] - b[0], 2) + Math.pow(a[1] - b[1], 2));
    }
}
