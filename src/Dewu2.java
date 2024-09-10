import java.util.HashMap;
import java.util.Scanner;

public class Dewu2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int k = in.nextInt();
        String s = in.next();

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i <= n - k;) {
            String subString = s.substring(i, i + k);

            char firstChar = s.charAt(i);
            if (isGoodString(subString)) {
                Integer count = map.get(firstChar);
                if (count == null) {
                    map.put(firstChar, 1);
                } else {
                    count++;
                    map.put(firstChar, count);
                }

                i += k;
            } else {
                i++;
            }
        }

        int count = Integer.MIN_VALUE;
        for (char c : map.keySet()) {
            count = Math.max(count, map.get(c));
        }

        System.out.println(count);
    }

    private static boolean isGoodString(String str) {
        char firstChar = str.charAt(0);
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) != firstChar) {
                return false;
            }
        }

        return true;
    }
}
