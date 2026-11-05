# Unit 4 — Dynamic Programming (Java)

This folder includes the requested algorithms:

- Memoized Fibonacci
- 0/1 Knapsack
- Multistage Graph shortest path
- Floyd–Warshall all-pairs shortest paths
- Bellman–Ford single-source shortest path
- Travelling Salesman Problem (TSP) using Held–Karp bitmask DP

## Compile and run

From this folder:

```bash
javac MemoizedFibonacci.java
java MemoizedFibonacci
```

For other programs, replace the filename/class name with the desired one.

## Complexity summary

| Algorithm | Time | Space |
|---|---:|---:|
| Memoized Fibonacci | O(n) | O(n) |
| 0/1 Knapsack | O(nW) | O(nW) |
| Multistage Graph | O(V²) for adjacency matrix | O(V) |
| Floyd–Warshall | O(V³) | O(V²) |
| Bellman–Ford | O(VE) | O(V) |
| TSP Held–Karp | O(n²·2ⁿ) | O(n·2ⁿ) |

The examples use zero-based vertex numbering. For graph examples, `0` denotes no edge where applicable. Bellman–Ford uses an edge list and can handle negative edge weights (but reports reachable negative cycles).
