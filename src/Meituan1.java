import java.util.*;

public class Meituan1 {
    public static void main(String[] args) {
        HashSet<String> candidates = new HashSet<>();
        HashMap<Integer, ArrayList<String>> map = new HashMap<>();

        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        String expected = in.nextLine();
        for (int i = 0; i < n; i++) {
            candidates.add(in.nextLine());
        }

        for (String candidate : candidates) {
            int len = candidate.length();
            ArrayList<String> set = map.get(len);
            if (set == null) {
                set = new ArrayList<>();
                set.add(candidate);
                map.put(len, set);
            } else {
                set.add(candidate);
            }
        }

        List<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);

        int min = 0;
        int max = 0;
        for (int key : keys) {
            ArrayList<String> set = map.get(key);
            if (set.contains(expected)) {
                min += 1;
                max += set.size();
                break;
            } else {
                min += set.size();
                max += set.size();
            }
        }

        System.out.println(min + " " + max);
    }
}
