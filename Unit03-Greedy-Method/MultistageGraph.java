import java.util.Arrays;

public class MultistageGraph {
    private static final int INF = 1_000_000_000;

    // Vertices are numbered 0..n-1. Edges are directed toward later stages.
    public static void shortestPath(int[][] graph, int source, int destination) {
        int n = graph.length;
        int[] cost = new int[n];
        int[] next = new int[n];
        Arrays.fill(cost, INF);
        Arrays.fill(next, -1);
        cost[destination] = 0;

        // Dynamic programming from destination back toward source.
        for (int u = destination - 1; u >= source; u--) {
            for (int v = u + 1; v < n; v++) {
                if (graph[u][v] != 0 && cost[v] != INF) {
                    int candidate = graph[u][v] + cost[v];
                    if (candidate < cost[u]) {
                        cost[u] = candidate;
                        next[u] = v;
                    }
                }
            }
        }

        if (cost[source] == INF) {
            System.out.println("No path exists.");
            return;
        }

        System.out.println("Minimum cost = " + cost[source]);
        System.out.print("Path: ");
        int current = source;
        while (current != -1) {
            System.out.print(current);
            if (current == destination) break;
            System.out.print(" -> ");
            current = next[current];
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // 0 means no edge. Directed multistage graph.
        int[][] graph = {
            {0, 2, 1, 0, 0, 0},
            {0, 0, 0, 3, 2, 0},
            {0, 0, 0, 2, 4, 0},
            {0, 0, 0, 0, 0, 2},
            {0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 0, 0}
        };
        shortestPath(graph, 0, graph.length - 1);
    }
}
