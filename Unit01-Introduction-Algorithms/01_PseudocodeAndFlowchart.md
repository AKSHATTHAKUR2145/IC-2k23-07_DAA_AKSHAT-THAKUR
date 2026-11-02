# Binary Search: Pseudocode & Flowchart

## 1. Pseudocode (Iterative Binary Search)
```text
ALGORITHM BinarySearch(A[0..n-1], key)
// Input: A sorted array A of size n, and a search element 'key'
// Output: Index of 'key' in A, or -1 if not found

low <- 0
high <- n - 1

WHILE low <= high DO
    mid <- low + (high - low) / 2
    IF A[mid] == key THEN
        RETURN mid
    ELSE IF A[mid] < key THEN
        low <- mid + 1
    ELSE
        high <- mid - 1
    END IF
END WHILE

RETURN -1
```

## 2. Flowchart
```mermaid
flowchart TD
    A([Start]) --> B[/Input Sorted Array A, size n, key/]
    B --> C[low = 0, high = n - 1]
    C --> D{low <= high ?}
    D -- No --> E[/Return -1: Not Found/]
    E --> Z([End])
    D -- Yes --> F["mid = low + (high - low) / 2"]
    F --> G{"A[mid] == key ?"}
    G -- Yes --> H[/Return mid/]
    H --> Z
    G -- No --> I{"A[mid] < key ?"}
    I -- Yes --> J[low = mid + 1]
    I -- No --> K[high = mid - 1]
    J --> D
    K --> D
```
