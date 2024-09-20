import java.util.HashMap;
import java.util.Scanner;

public class Xiaohongshu1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        long k = scanner.nextLong();

        HashMap<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            long key = scanner.nextLong();
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }

        int count = 0;
        for (long key : map.keySet()) {
            long v = key ^ k;
            if (map.containsKey(v)) {
                count += map.get(v) * map.get(key);
            }
        }

        System.out.println(count / 2);
    }
}
