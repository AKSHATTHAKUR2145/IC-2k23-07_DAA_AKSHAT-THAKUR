import java.util.*;

public class RatInMaze {
    public static List<String> findPaths(int[][] maze) {
        List<String> paths = new ArrayList<>();
        int n = maze.length;
        if (n == 0 || maze[0].length == 0 || maze[0][0] == 0) return paths;

        boolean[][] visited = new boolean[n][maze[0].length];
        dfs(maze, 0, 0, visited, new StringBuilder(), paths);
        return paths;
    }

    private static final int[] DR = {1, 0, 0, -1};
    private static final int[] DC = {0, -1, 1, 0};
    private static final char[] MOVE = {'D', 'L', 'R', 'U'};

    private static void dfs(int[][] maze, int r, int c, boolean[][] visited,
                            StringBuilder path, List<String> paths) {
        int n = maze.length, m = maze[0].length;
        if (r == n - 1 && c == m - 1) {
            paths.add(path.toString());
            return;
        }

        visited[r][c] = true;

        for (int i = 0; i < 4; i++) {
            int nr = r + DR[i], nc = c + DC[i];
            if (nr >= 0 && nr < n && nc >= 0 && nc < m
                    && maze[nr][nc] != 0 && !visited[nr][nc]) {
                path.append(MOVE[i]);
                dfs(maze, nr, nc, visited, path, paths);
                path.deleteChar(path.length() - 1);
            }
        }

        visited[r][c] = false;
    }
}
