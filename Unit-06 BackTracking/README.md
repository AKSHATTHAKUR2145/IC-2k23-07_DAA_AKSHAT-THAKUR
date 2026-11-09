# Unit 6 — Backtracking (CO4)

Programs: QueensSolver (4/8/N queens), SumOfSubsets, SudokuSolver, GraphColoring, BacktrackingAnalysis.

Compile and run, for example:
```bash
javac QueensSolver.java
java QueensSolver
```

General backtracking structure: choose a candidate, test constraints, recurse, and undo the choice. The included analysis reports solution counts, visited nodes, elapsed time, and compares row-wise N-Queens backtracking against exhaustive enumeration. Naive N-Queens assignments have search-space size N^N. Known solution counts N=1..8: 1, 0, 0, 2, 10, 4, 40, 92.
