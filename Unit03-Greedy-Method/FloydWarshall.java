import java.util.Arrays;

public class FloydWarshall {
    private static final int INF = 1_000_000_000;

    // Computes shortest distances between every pair of vertices.
    // Time: O(V^3), Space: O(V^2)
    public static void floydWarshall(int[][] dist) {
        int n = dist.length;

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] != INF && dist[k][j] != INF) {
                        dist[i][j] = Math.min(dist[i][j],
                                dist[i][k] + dist[k][j]);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] dist = {
            {0, 5, INF, 10},
            {INF, 0, 3, INF},
            {INF, INF, 0, 1},
            {INF, INF, INF, 0}
        };

        floydWarshall(dist);
        System.out.println("All-pairs shortest distance matrix:");
        for (int[] row : dist) {
            for (int value : row)
                System.out.print((value == INF ? "INF" : value) + "\t");
            System.out.println();
        }
    }
}
