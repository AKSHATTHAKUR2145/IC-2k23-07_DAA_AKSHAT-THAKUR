import java.util.*;

public class KruskalMST {
    public static class Edge {
        public int u, v, weight;
        public Edge(int u, int v, int weight) {
            this.u = u; this.v = v; this.weight = weight;
        }
    }

    private static class DSU {
        int[] parent, rank;
        DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }
        int find(int x) {
            if (parent[x] != x) parent[x] = find(parent[x]);
            return parent[x];
        }
        boolean union(int a, int b) {
            a = find(a); b = find(b);
            if (a == b) return false;
            if (rank[a] < rank[b]) parent[a] = b;
            else if (rank[a] > rank[b]) parent[b] = a;
            else { parent[b] = a; rank[a]++; }
            return true;
        }
    }

    public static List<Edge> mst(int vertices, List<Edge> edges) {
        edges.sort(Comparator.comparingInt(e -> e.weight));
        DSU dsu = new DSU(vertices);
        List<Edge> result = new ArrayList<>();

        for (Edge edge : edges)
            if (dsu.union(edge.u, edge.v)) result.add(edge);

        return result;
    }
}
