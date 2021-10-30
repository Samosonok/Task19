
/**
 * @author Samosonok Liliia
 * @version 1.0
 */

public class GameOfLife {

    private static final int m = 8;
    private static final int n = 8;
    static int[][] newMatrix = new int[n][m];

    public static void main(String[] args) {
        int[][] matrix = {{0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 1, 0, 0, 0},
                {0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0}
        };

        System.out.println("Matrix");
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                if (matrix[x][y] == 0)
                    System.out.print("-");
                else
                    System.out.print("*");
            }
            System.out.println();
        }
        getNewMatrix(matrix);
    }

    public static int[][] getNewMatrix(int[][] matrix) {
        for (int a = 1; a < m - 1; a++) {
            for (int b = 1; b < n - 1; b++) {
                int aliveNeighbours = 0;
                for (int c = -1; c <= 1; c++) {
                    for (int d = -1; d <= 1; d++) {
                        aliveNeighbours += matrix[a + c][b + d];
                    }
                }
                aliveNeighbours -= matrix[a][b];
                if ((matrix[a][b] == 1) && (aliveNeighbours < 2)) {
                    newMatrix[a][b] = 0;
                } else if ((matrix[a][b] == 1) && (aliveNeighbours > 3)) {
                    newMatrix[a][b] = 0;
                } else if ((matrix[a][b] == 0) && (aliveNeighbours == 3)) {
                    newMatrix[a][b] = 1;
                } else newMatrix[a][b] = matrix[a][b];
            }
        }
        System.out.println("New matrix");
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                if (newMatrix[x][y] == 0)
                    System.out.print("-");
                else
                    System.out.print("*");
            }
            System.out.println();
        }
        return newMatrix;
    }
}
