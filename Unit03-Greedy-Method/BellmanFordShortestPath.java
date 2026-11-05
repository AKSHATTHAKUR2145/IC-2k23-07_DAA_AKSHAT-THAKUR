import java.util.Arrays;

public class BellmanFordShortestPath {
    static class Edge {
        int from, to, weight;
        Edge(int from, int to, int weight) {
            this.from = from; this.to = to; this.weight = weight;
        }
    }

    // Single-source shortest path; supports negative edges.
    // Time: O(VE). Detects reachable negative-weight cycles.
    public static void bellmanFord(int vertices, Edge[] edges, int source) {
        final int INF = 1_000_000_000;
        int[] dist = new int[vertices];
        Arrays.fill(dist, INF);
        dist[source] = 0;

        for (int i = 1; i < vertices; i++) {
            boolean changed = false;
            for (Edge e : edges) {
                if (dist[e.from] != INF && dist[e.from] + e.weight < dist[e.to]) {
                    dist[e.to] = dist[e.from] + e.weight;
                    changed = true;
                }
            }
            if (!changed) break;
        }

        for (Edge e : edges) {
            if (dist[e.from] != INF && dist[e.from] + e.weight < dist[e.to]) {
                System.out.println("Negative-weight cycle detected.");
                return;
            }
        }

        System.out.println("Shortest distances from source " + source + ":");
        for (int v = 0; v < vertices; v++)
            System.out.println("To " + v + " = " + (dist[v] == INF ? "INF" : dist[v]));
    }

    public static void main(String[] args) {
        int vertices = 5;
        Edge[] edges = {
            new Edge(0, 1, 6),
            new Edge(0, 2, 7),
            new Edge(1, 2, 8),
            new Edge(1, 3, 5),
            new Edge(1, 4, -4),
            new Edge(2, 3, -3),
            new Edge(2, 4, 9),
            new Edge(3, 1, -2),
            new Edge(4, 0, 2),
            new Edge(4, 3, 7)
        };
        bellmanFord(vertices, edges, 0);
    }
}
