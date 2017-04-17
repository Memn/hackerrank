package memn.hackerrank.datastructures.arrays;

import java.util.Scanner;

/**
 * AlgorithmicCrush.
 * @see https://codereview.stackexchange.com/questions/95755/algorithmic-crush-problem-hitting-timeout-errors/95812#95812
 * Created by Memn on 17.04.2017.
 */
public class AlgorithmicCrush {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int m = scanner.nextInt();

    long[] crushes = new long[n + 1];
    for (int i = 0; i < m; i++) {
      int a = scanner.nextInt();
      int b = scanner.nextInt();
      int k = scanner.nextInt();
      crushes[a - 1] += k;
      crushes[b] -= k;
    }

    long max = Long.MIN_VALUE;
    long prefixSum = 0;
    for (int i = 0; i < n; i++) {
      prefixSum += crushes[i];
      if (prefixSum > max) {
        max = prefixSum;
      }
    }

    System.out.println(max);
  }
}
