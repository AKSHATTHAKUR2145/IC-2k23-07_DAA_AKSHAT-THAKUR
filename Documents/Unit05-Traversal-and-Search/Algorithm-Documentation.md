# Unit 5 — Traversal and Search

For each algorithm: concept, pseudocode, algorithm-specific flowchart, and complexity.

## Binary Tree Traversals

**Concept:** Visit every node in a specific order: preorder, inorder, or postorder.

**Pseudocode:**
```text
preorder: root,left,right; inorder: left,root,right; postorder: left,right,root
```

**Flowchart:**
```mermaid
flowchart TD
S["Start"]
N1["Visit root/left/right in selected order"]
N2["output sequence"]
E["End"]
S --> N1
N1 --> N2
N2 --> E
```

**Complexity:**
- Best: `O(n)`
- Average: `O(n)`
- Worst: `O(n)`
- Auxiliary space: `O(h) recursion stack`

**Representative output:**
```text
Preorder: 1 2 4 5 3 6 7 | Inorder: 4 2 5 1 6 3 7 | Postorder: 4 5 2 6 7 3 1
```


## Graph Representation

**Concept:** Represent graph connections using an adjacency matrix or adjacency list.

**Pseudocode:**
```text
for each edge(u,v): matrix[u][v]=1; list[u].add(v)
```

**Flowchart:**
```mermaid
flowchart TD
S["Start"]
N1["Read vertices/edges"]
N2["populate matrix and lists"]
N3["display"]
E["End"]
S --> N1
N1 --> N2
N2 --> N3
N3 --> E
```

**Complexity:**
- Best: `O(V+E) list construction`
- Average: `O(V+E)`
- Worst: `O(V²) matrix`
- Auxiliary space: `O(V²) matrix; O(V+E) list`

**Representative output:**
```text
Adjacency list: 0→[1,2], 1→[0,3,4], 2→[0,4], 3→[1], 4→[1,2]
```


## BFS

**Concept:** Explore a graph level by level using a queue.

**Pseudocode:**
```text
mark source; enqueue; while queue not empty: dequeue u; visit/enqueue unvisited neighbors
```

**Flowchart:**
```mermaid
flowchart TD
S["Start"]
N1["Queue source"]
N2["dequeue"]
N3["visit neighbors"]
N4["enqueue unseen vertices"]
N5["repeat"]
E["End"]
S --> N1
N1 --> N2
N2 --> N3
N3 --> N4
N4 --> N5
N5 --> E
```

**Complexity:**
- Best: `O(V+E)`
- Average: `O(V+E)`
- Worst: `O(V+E)`
- Auxiliary space: `O(V)`

**Representative output:**
```text
BFS traversal: 0 1 2 3 4 5
```


## DFS

**Concept:** Explore as far as possible along a branch before backtracking.

**Pseudocode:**
```text
dfs(u): visited[u]=true; for v in adj[u]: if not visited[v] dfs(v)
```

**Flowchart:**
```mermaid
flowchart TD
S["Start"]
N1["Visit node"]
N2["recursively explore unvisited neighbor"]
N3["backtrack when done"]
E["End"]
S --> N1
N1 --> N2
N2 --> N3
N3 --> E
```

**Complexity:**
- Best: `O(V+E)`
- Average: `O(V+E)`
- Worst: `O(V+E)`
- Auxiliary space: `O(V)`

**Representative output:**
```text
DFS traversal: 0 1 3 5 4 2
```

> Note: Output lines and output sheets are representative references, not screenshots captured from live execution of the repository's exact source files.