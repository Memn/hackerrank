package memn.hackerrank.datastructures.arrays;

import java.util.Scanner;

/**
 * HourGlassMaxSum.
 * Created by Memn on 17.04.2017.
 */
public class HourGlassMaxSum {

  public static void main(String[] args) {
    int[][] matrix = readInput();
    int sum = maxSumHourGlass(matrix);
    System.out.println(sum);
  }

  private static int maxSumHourGlass(final int[][] matrix) {
    int sum = Integer.MIN_VALUE;
    int maxSum = sum;
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 4; j++) {
        sum = hourGlassSum(matrix, i, j);
        if (maxSum < sum) {
          maxSum = sum;
        }
      }
    }
    return maxSum;
  }

  private static int hourGlassSum(int[][] matrix, int row, int column) {
    if (row > 3 || column > 3) {
      throw new IllegalArgumentException("Row or column must be smaller than 4.");
    }
    return matrix[row][column] + matrix[row][column + 1] + matrix[row][column + 2]
        + matrix[row + 1][column + 1]
        + matrix[row + 2][column] + matrix[row + 2][column + 1] + matrix[row + 2][column + 2];
  }

  private static int[][] readInput() {
    Scanner scanner = new Scanner(System.in);
    // 6 x 6 ints
    int[][] matrix = new int[6][6];
    for (int i = 0; i < 6; i++) {
      for (int j = 0; j < 6; j++) {
        matrix[i][j] = scanner.nextInt();
      }
    }
    return matrix;
  }

}
