import java.util.Scanner;

public class Mihoyo2 {

    private static int maxPoint = 0;
    static class Challenge {
        public int[] awards = new int[3];
        public int[] hero = new int[3];

        Challenge(int a1, int a2, int a3, int h1, int h2, int h3) {
            awards[0] = a1;
            awards[1] = a2;
            awards[2] = a3;
            hero[0] = h1;
            hero[1] = h2;
            hero[2] = h3;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();
        int[] extra = new int[m];
        for (int i = 0; i < m; i++) {
            extra[i] = in.nextInt();
        }

        Challenge[] challenges = new Challenge[n];
        for (int i = 0; i < n; i++) {
            int a1 = in.nextInt();
            int a2 = in.nextInt();
            int a3 = in.nextInt();
            int h1 = in.nextInt();
            int h2 = in.nextInt();
            int h3 = in.nextInt();
            challenges[i] = new Challenge(a1, a2, a3, h1, h2, h3);
        }

        int[] heroCount = new int[m];
        compute(n, m, 0, 0, challenges, extra, heroCount);
        System.out.println(maxPoint);
    }

    private static void compute(int n, int m, int challengeNo, int points, Challenge[] challenges, int[] extra, int[] heroCount) {
        if (challengeNo >= n) {
            System.out.println("max: " + maxPoint + " cur: " + points);
            maxPoint = Math.max(points, maxPoint);
            return;
        }

        Challenge challenge = challenges[challengeNo];
        for (int i = 0; i < 3; i++) {
            System.out.println(challengeNo + " " + i);
            int a = challenge.awards[i];
            int h = challenge.hero[i];
            int newPoints = points + a;
            if (heroCount[h - 1] + 1 == 3) {
                newPoints += extra[h - 1];
            }

            int[] newHeroCount = new int[m];
            System.arraycopy(heroCount, 0, newHeroCount, 0, m);
            newHeroCount[h - 1] += 1;
            compute(n, m, challengeNo + 1, newPoints, challenges, extra, newHeroCount);
        }
    }
}
