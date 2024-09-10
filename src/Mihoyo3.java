import java.util.*;

public class Mihoyo3 {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static int n, m;

    static boolean isValid(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    static int dfs(int x, int y, int id, char[][] grid, int[][] idMap, boolean[][] visited) {
        visited[x][y] = true;
        idMap[x][y] = id;
        int size = 1;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i], ny = y + dy[i];
            if (isValid(nx, ny) && !visited[nx][ny] && grid[nx][ny] == '#') {
                size += dfs(nx, ny, id, grid, idMap, visited);
            }
        }

        return size;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        m = in.nextInt();
        char[][] grid = new char[n][m];
        in.nextLine();
        for (int i = 0; i < n; i++) {
            grid[i] = in.nextLine().toCharArray();
        }

        boolean[][] visited = new boolean[n][m];
        int[][] idMap = new int[n][m];
        List<Integer> landSizes = new ArrayList<>();

        int id = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && grid[i][j] == '#') {
                    int size = dfs(i, j, id, grid, idMap, visited);
                    landSizes.add(size);
                    id++;
                }
            }
        }

        int maxLandSize = landSizes.stream().max(Integer::compare).orElse(0);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '.') {
                    Set<Integer> neighboringLands = new HashSet<>();
                    int newSize = 1;

                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k], ny = j + dy[k];
                        if (isValid(nx, ny) && grid[nx][ny] == '#') {
                            int landId = idMap[nx][ny];
                            if (!neighboringLands.contains(landId)) {
                                neighboringLands.add(landId);
                                newSize += landSizes.get(landId);
                            }
                        }
                    }

                    maxLandSize = Math.max(maxLandSize, newSize);
                }
            }
        }

        System.out.println(maxLandSize);
    }
}
