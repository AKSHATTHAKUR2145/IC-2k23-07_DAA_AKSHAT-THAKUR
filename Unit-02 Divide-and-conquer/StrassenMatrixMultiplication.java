import java.util.Arrays;

public class StrassenMatrixMultiplication {
    // Strassen implementation for square matrices with power-of-two dimension.
    public static int[][] multiply(int[][] A, int[][] B) {
        int n = A.length;
        if (n == 1) return new int[][]{{A[0][0] * B[0][0]}};

        int half = n / 2;
        int[][] a11 = subMatrix(A, 0, 0, half), a12 = subMatrix(A, 0, half, half);
        int[][] a21 = subMatrix(A, half, 0, half), a22 = subMatrix(A, half, half, half);
        int[][] b11 = subMatrix(B, 0, 0, half), b12 = subMatrix(B, 0, half, half);
        int[][] b21 = subMatrix(B, half, 0, half), b22 = subMatrix(B, half, half, half);

        int[][] m1 = multiply(add(a11, a22), add(b11, b22));
        int[][] m2 = multiply(add(a21, a22), b11);
        int[][] m3 = multiply(a11, subtract(b12, b22));
        int[][] m4 = multiply(a22, subtract(b21, b11));
        int[][] m5 = multiply(add(a11, a12), b22);
        int[][] m6 = multiply(subtract(a21, a11), add(b11, b12));
        int[][] m7 = multiply(subtract(a12, a22), add(b21, b22));

        int[][] c11 = add(subtract(add(m1, m4), m5), m7);
        int[][] c12 = add(m3, m5);
        int[][] c21 = add(m2, m4);
        int[][] c22 = add(subtract(add(m1, m3), m2), m6);

        int[][] C = new int[n][n];
        put(C, c11, 0, 0); put(C, c12, 0, half);
        put(C, c21, half, 0); put(C, c22, half, half);
        return C;
    }

    private static int[][] subMatrix(int[][] A, int row, int col, int size) {
        int[][] out = new int[size][size];
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++) out[i][j] = A[row + i][col + j];
        return out;
    }

    private static void put(int[][] dest, int[][] src, int row, int col) {
        for (int i = 0; i < src.length; i++)
            for (int j = 0; j < src.length; j++) dest[row + i][col + j] = src[i][j];
    }

    private static int[][] add(int[][] A, int[][] B) {
        int n = A.length; int[][] C = new int[n][n];
        for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) C[i][j] = A[i][j] + B[i][j];
        return C;
    }

    private static int[][] subtract(int[][] A, int[][] B) {
        int n = A.length; int[][] C = new int[n][n];
        for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) C[i][j] = A[i][j] - B[i][j];
        return C;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) System.out.println(Arrays.toString(row));
    }

    public static void main(String[] args) {
        int[][] A = {{1, 2}, {3, 4}};
        int[][] B = {{5, 6}, {7, 8}};

        System.out.println("Matrix A:");
        printMatrix(A);
        System.out.println("Matrix B:");
        printMatrix(B);
        System.out.println("A x B using Strassen:");
        printMatrix(multiply(A, B));
    }
}
