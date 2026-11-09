# Unit 5 — Traversal & Search (Java)

This folder contains Java implementations of:

- Binary Tree Traversals (Preorder, Inorder, Postorder)
- Graph Representation (Adjacency Matrix and Adjacency List)
- Breadth-First Search (BFS)
- Depth-First Search (DFS)

## Compile and run

From this directory, compile and run any program. Example:

```bash
javac BinaryTreeTraversals.java
java BinaryTreeTraversals
```

Replace `BinaryTreeTraversals` with the selected Java filename/class name.

## Complexity

| Algorithm | Time | Extra space |
|---|---:|---:|
| Binary tree traversals | O(n) | O(h) recursion stack |
| Adjacency matrix storage | O(V²) | O(V²) |
| Adjacency list storage | O(V + E) | O(V + E) |
| BFS | O(V + E) | O(V) |
| DFS | O(V + E) | O(V) |

The graph examples are undirected and use vertices numbered from `0`. For directed graphs, add edges in only one direction.
