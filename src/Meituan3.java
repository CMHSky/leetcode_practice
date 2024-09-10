import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Meituan3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            results.add(find(n));
        }

        in.close();

        for (int gcd : results) {
            System.out.println(gcd);
        }
    }

    private static int find(int n) {
        for (int m = n; m >=2; m--) {
            int gcd = gcd(n, m);
            if (isPrime(gcd)) {
                return m;
            }
        }

        return -1;
    }

    private static int gcd(int n, int m) {
        if (m == 0) {
            return n;
        }

        return gcd(m, n % m);
    }

    private static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }

        if (n == 2 || n == 3) {
            return true;
        }

        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }

        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }

        return true;
    }
}
