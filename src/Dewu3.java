import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Dewu3 {
    static class State {
        int x;
        int y;
        int steps;
        int bombsUsed;

        State(int x, int y, int steps, int bombsUsed) {
            this.x = x;
            this.y = y;
            this.steps = steps;
            this.bombsUsed = bombsUsed;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();
        in.nextLine();

        char[][] grid = new char[n][m];
        boolean[][][] visited = new boolean[n][m][4];

        State start = null;
        for (int i = 0; i < n; i++) {
            String line = in.nextLine();
            for (int j = 0; j < m; j++) {
                grid[i][j] = line.charAt(j);
                if (grid[i][j] == 'B') {
                    start = new State(i, j, 0, 0);
                }
            }
        }

        if (start == null) {
            System.out.println(-1);
            return;
        }

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        Queue<State> queue = new LinkedList<>();
        queue.offer(start);
        visited[start.x][start.y][0] = true;

        while (!queue.isEmpty()) {
            State current = queue.poll();

            if (grid[current.x][current.y] == '*') {
                System.out.println(current.steps);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (grid[nx][ny] == '.' || grid[nx][ny] == '*') {
                        if (!visited[nx][ny][current.bombsUsed]) {
                            visited[nx][ny][current.bombsUsed] = true;
                            queue.offer(new State(nx, ny, current.steps + 1, current.bombsUsed));
                        }
                    } else if (grid[nx][ny] == 'W' && current.bombsUsed < 3) {
                        if (!visited[nx][ny][current.bombsUsed + 1]) {
                            visited[nx][ny][current.bombsUsed + 1] = true;
                            queue.offer(new State(nx, ny, current.steps + 2, current.bombsUsed + 1));
                        }
                    }
                }
            }
        }

        System.out.println(-1);
    }
}
