import java.util.*;

public class HamiltonianCycle {
    public static List<Integer> findCycle(int[][] graph) {
        int n = graph.length;
        int[] path = new int[n];
        Arrays.fill(path, -1);
        boolean[] used = new boolean[n];

        path[0] = 0;
        used[0] = true;

        if (!solve(graph, path, used, 1)) return new ArrayList<>();

        List<Integer> result = new ArrayList<>();
        for (int v : path) result.add(v);
        result.add(0);
        return result;
    }

    private static boolean solve(int[][] graph, int[] path, boolean[] used, int pos) {
        if (pos == graph.length)
            return graph[path[pos - 1]][path[0]] != 0;

        for (int v = 1; v < graph.length; v++) {
            if (!used[v] && graph[path[pos - 1]][v] != 0) {
                path[pos] = v;
                used[v] = true;

                if (solve(graph, path, used, pos + 1)) return true;

                used[v] = false;
                path[pos] = -1;
            }
        }
        return false;
    }
}
