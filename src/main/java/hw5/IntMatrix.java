package hw5;

import java.util.Arrays;
import java.util.Random;

public class IntMatrix {
    private int[][] matrix;

    public IntMatrix(int rows, int cols) {
        matrix = new int[rows][cols];
    }

    public IntMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    /**
     * Заполнить матрицу случайными значениями
     *
     * @param minValue минимальное значение (включительно)
     * @param maxValue максимальное значение (не включительно)
     */
    public void fillRandom(int minValue, int maxValue) {
        Random random = new Random();
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = random.nextInt(maxValue - minValue) + minValue;
            }
        }
    }

    public void printMatrix() {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.printf("%4d", matrix[row][col]);
            }
            System.out.println();
        }
    }

    /**
     * Повернуть матрицу на 90.
     * <pre><code>
     * 1 2 3        7 4 1
     * 4 5 6   ->   8 5 2
     * 7 8 9        9 6 3
     * </code></pre>
     * <pre><code>
     * 1 2 3 4       5 1
     * 5 6 7 8  ->   6 2
     *               7 3
     *               8 4
     * </code></pre>
     *
     * @return Матрица повернутая на 90
     */
    public IntMatrix getRotate90Matrix() {
        int rowsCount = matrix.length;
        int colsCount = matrix[0].length;
        int[][] rotateMatrix = new int[colsCount][rowsCount];

        for (int row = 0; row < rowsCount; row++) {
            for (int col = 0; col < colsCount; col++) {
                rotateMatrix[col][rowsCount - 1 - row] = matrix[row][col];
            }
        }

        return new IntMatrix(rotateMatrix);
    }

    /**
     * Повернуть матрицу на 180.
     * <pre><code>
     * 1 2 3        9 8 7
     * 4 5 6   ->   6 5 4
     * 7 8 9        3 2 1
     * </code></pre>
     * <pre><code>
     * 1 2 3 4  ->  8 7 6 5
     * 5 6 7 8      4 3 2 1
     * </code></pre>
     *
     * @return Матрица повернутая на 180
     */
    public IntMatrix getRotate180Matrix() {
        int rowsCount = matrix.length;
        int colsCount = matrix[0].length;
        int[][] rotateMatrix = new int[rowsCount][colsCount];

        for (int row = 0; row < rowsCount; row++) {
            for (int col = 0; col < colsCount; col++) {
                rotateMatrix[rowsCount - 1 - row][colsCount - 1 - col] = matrix[row][col];
            }
        }

        return new IntMatrix(rotateMatrix);
    }


    /**
     * Повернуть матрицу на 270.
     * <pre><code>
     * 1 2 3        3 6 9
     * 4 5 6   ->   2 5 8
     * 7 8 9        1 4 7
     * </code></pre>
     * <pre><code>
     * 1 2 3 4       4 8
     * 5 6 7 8  ->   3 7
     *               2 6
     *               1 5
     * </code></pre>
     *
     * @return Матрица повернутая на 270
     */
    public IntMatrix getRotate270Matrix() {
        int rowsCount = matrix.length;
        int colsCount = matrix[0].length;
        int[][] rotateMatrix = new int[colsCount][rowsCount];

        for (int row = 0; row < rowsCount; row++) {
            for (int col = 0; col < colsCount; col++) {
                rotateMatrix[colsCount - 1 - col][row] = matrix[row][col];
            }
        }

        return new IntMatrix(rotateMatrix);
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        IntMatrix otherMatrix = (IntMatrix) object;

        return Arrays.deepEquals(matrix, otherMatrix.matrix);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(matrix);
    }
}