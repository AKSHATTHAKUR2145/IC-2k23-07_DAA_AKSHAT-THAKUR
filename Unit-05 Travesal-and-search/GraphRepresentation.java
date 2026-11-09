import java.util.*;

public class GraphRepresentation {
    public static void main(String[] args) {
        int vertices = 5;
        int[][] edges = {
            {0, 1}, {0, 2}, {1, 3}, {1, 4}, {2, 4}
        };

        // Adjacency matrix
        int[][] matrix = new int[vertices][vertices];
        // Adjacency list
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < vertices; i++) list.add(new ArrayList<>());

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            matrix[u][v] = matrix[v][u] = 1; // undirected graph
            list.get(u).add(v);
            list.get(v).add(u);
        }

        System.out.println("Adjacency Matrix:");
        for (int[] row : matrix) {
            for (int value : row) System.out.print(value + " ");
            System.out.println();
        }

        System.out.println("\nAdjacency List:");
        for (int i = 0; i < vertices; i++)
            System.out.println(i + " -> " + list.get(i));
    }
}
