import java.util.*;

public class PrimMST {
    public static int[] mst(int[][] graph) {
        int n = graph.length;
        int[] key = new int[n];
        int[] parent = new int[n];
        boolean[] used = new boolean[n];

        Arrays.fill(key, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);
        key[0] = 0;

        for (int count = 0; count < n; count++) {
            int u = -1;
            for (int i = 0; i < n; i++)
                if (!used[i] && (u == -1 || key[i] < key[u])) u = i;

            used[u] = true;

            for (int v = 0; v < n; v++)
                if (graph[u][v] != 0 && !used[v] && graph[u][v] < key[v]) {
                    key[v] = graph[u][v];
                    parent[v] = u;
                }
        }
        return parent;
    }
}
