# Unit 7 — NP-Hard, NP-Complete & Advanced Optimization (CO5, CO7)

Included Java programs:
- `ExhaustiveSearch`: small pair-sum problem
- `KnapsackBranchBound`: 0/1 Knapsack with branch-and-bound and fractional upper bound
- `TSPBranchBound`: TSP branch-and-bound with incumbent pruning
- `KnapsackComparison`: DP vs Branch-and-Bound (value, timing, node count)
- `DPvsBranchBoundTSP`: Held-Karp DP vs branch-and-bound TSP
- `OptimizationComparisonSystem`: subset exhaustive search and search-space demonstration

Compile/run:
```bash
javac KnapsackBranchBound.java
java KnapsackBranchBound
```

Performance notes: timings are machine/JVM dependent. The sample programs report runtime and explored states/nodes where implemented. DP often has predictable state complexity; branch-and-bound can prune strongly on favorable inputs but has exponential worst-case behavior. TSP exhaustive enumeration grows as (n-1)!; subset-based DP grows O(n^2 2^n).
