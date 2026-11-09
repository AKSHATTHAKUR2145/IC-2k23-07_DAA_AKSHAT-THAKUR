import java.util.*;

public class DFS {
    public static void dfs(List<List<Integer>> graph, int vertex, boolean[] visited) {
        visited[vertex] = true;
        System.out.print(vertex + " ");

        for (int neighbor : graph.get(vertex)) {
            if (!visited[neighbor]) dfs(graph, neighbor, visited);
        }
    }

    public static void main(String[] args) {
        int vertices = 6;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < vertices; i++) graph.add(new ArrayList<>());

        int[][] edges = {{0,1},{0,2},{1,3},{1,4},{2,4},{3,5},{4,5}};
        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]); // undirected graph
        }

        boolean[] visited = new boolean[vertices];
        System.out.print("DFS traversal: ");
        dfs(graph, 0, visited);
        System.out.println();
    }
}
