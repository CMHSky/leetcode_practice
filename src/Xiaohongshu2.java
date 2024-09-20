import java.util.Scanner;

public class Xiaohongshu2 {
    static class Params {
        private final int x;
        private final int y;
        private final int z;
        private final int k;

        Params(int x, int y, int z, int k) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.k = k;
        }

        public int compute() {
            int numX = 0;
            if (k <= x) {
                numX = y * z * (x - k + 1);
            }

            int numY = 0;
            if (k <= y) {
                numY = x * z * (y - k + 1);
            }

            int numZ = 0;
            if (k <= z) {
                numZ = x * y* (z - k + 1);
            }

            return Math.max(Math.max(numX, numY), numZ);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        Params[] groups = new Params[n];
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int z = scanner.nextInt();
            int k = scanner.nextInt();
            groups[i] = new Params(x, y, z, k);
        }

        for (Params p : groups) {
            System.out.println(p.compute());
        }
    }
}
