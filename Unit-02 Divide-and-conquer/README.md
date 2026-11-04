# Unit 2 — Divide and Conquer (Java)

This folder contains Java implementations of the Unit 2 algorithms:

- Binary Search
- Max-Min (divide-and-conquer)
- Merge Sort
- Quick Sort
- Heap Sort
- Strassen Matrix Multiplication

## Compile and run

From this folder, compile an individual program and run it using the class name:

```bash
javac BinarySearch.java
java BinarySearch
```

Replace `BinarySearch` with the desired file/class name.

## Complexity summary

| Algorithm | Time complexity | Notes |
|---|---|---|
| Binary Search | O(log n) | Input must be sorted |
| Max-Min | O(n) | Divide-and-conquer |
| Merge Sort | O(n log n) | Uses O(n) extra space |
| Quick Sort | Average O(n log n), worst O(n²) | Last element is pivot |
| Heap Sort | O(n log n) | In-place sorting |
| Strassen | O(n^log₂7) ≈ O(n^2.807) | Square matrices with power-of-two dimensions |

Each `.java` file is self-contained and includes a `main()` method with sample input.
