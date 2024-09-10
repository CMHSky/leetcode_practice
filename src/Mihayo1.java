import java.util.Scanner;

public class Mihayo1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();

        int result = -1;
        int maxNum = 0;
        for (int i = n; i <= m; i++) {
            String s = String.valueOf(i);
            int count = 0;
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if (c == '4' || c == '6') {
                    count++;
                }
            }

            if (count >= maxNum) {
                maxNum = count;
                result = i;
            }
        }

        System.out.println(result);
    }
}
