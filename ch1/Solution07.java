package ch1;

import java.util.Scanner;

/**
 * Created by floyd on 9/10/2015.
 */
public class Solution07 {

    // rotate in clockwise
    public void rotateMatrix(int[][] matrix) {
        int size = matrix.length;
        for (int i = 0; i < size / 2; i++ )
            for (int j = i; j < size - i - 1; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[size - j - 1][i];
                matrix[size - j - 1][i] = matrix[size - i - 1][size - j - 1];
                matrix[size - i - 1][size - j - 1] = matrix[j][size - i - 1];
                matrix[j][size - i - 1] = t;
            }
    }

    private void run() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                matrix[i][j] = scanner.nextInt();
        rotateMatrix(matrix);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(matrix[i][j] + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Solution07 solution = new Solution07();
        solution.run();
    }

}
