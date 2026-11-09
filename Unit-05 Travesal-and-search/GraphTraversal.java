import java.util.*;

public class GraphTraversal {
    public static List<Integer> bfs(List<List<Integer>> graph, int start) {
        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[graph.size()];
        Queue<Integer> queue = new ArrayDeque<>();

        visited[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int u = queue.poll();
            result.add(u);

            for (int v : graph.get(u)) {
                if (!visited[v]) {
                    visited[v] = true;
                    queue.offer(v);
                }
            }
        }
        return result;
    }

    public static List<Integer> dfs(List<List<Integer>> graph, int start) {
        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[graph.size()];
        dfsRecursive(graph, start, visited, result);
        return result;
    }

    private static void dfsRecursive(List<List<Integer>> graph, int u,
                                     boolean[] visited, List<Integer> result) {
        visited[u] = true;
        result.add(u);

        for (int v : graph.get(u))
            if (!visited[v]) dfsRecursive(graph, v, visited, result);
    }

    public static List<Integer> shortestPath(List<List<Integer>> graph, int start, int target) {
        int[] parent = new int[graph.size()];
        Arrays.fill(parent, -1);
        boolean[] visited = new boolean[graph.size()];
        Queue<Integer> queue = new ArrayDeque<>();

        visited[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int u = queue.poll();
            if (u == target) break;

            for (int v : graph.get(u)) {
                if (!visited[v]) {
                    visited[v] = true;
                    parent[v] = u;
                    queue.offer(v);
                }
            }
        }

        if (!visited[target]) return new ArrayList<>();

        LinkedList<Integer> path = new LinkedList<>();
        for (int v = target; v != -1; v = parent[v]) path.addFirst(v);
        return path;
    }
}
