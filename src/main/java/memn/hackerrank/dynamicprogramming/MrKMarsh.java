package memn.hackerrank.dynamicprogramming;

import java.util.Scanner;

/**
 * Training for Capture the Flag contest.
 * Created by Memn on 26.04.2017.
 */
public class MrKMarsh {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int m = in.nextInt();
    int n = in.nextInt();
    in.nextLine();
    boolean[][] landMarshes = new boolean[m][n];
    for (int i = 0; i < m; i++) {
      String row = in.nextLine();
      int j = 0;
      for (char c : row.toCharArray()) {
        landMarshes[i][j++] = (c == 'x');
      }
    }
    int maxFence = perimeterMaxFence(landMarshes);
    System.out.println(maxFence == -1 ? "impossible" : maxFence);
  }

  private static int perimeterMaxFence(boolean[][] landMarshes) {
    // we need to find 4 points that are not marsh.
    // up-left and down-right are starts
    int up = 0;
    int left = 0;
    int down = landMarshes.length;
    int right = landMarshes[landMarshes.length - 1].length;
    return perimeterMaxFence(landMarshes, up, left, down, right);
  }

  static int perimeterMaxFence(boolean[][] landMarshes, int up, int left, int down, int right) {
    if (up<=down||left<=right)
      return -1;
    if (landMarshes[up][left])
      // needs to go right or down
      return 1;
    return -1;
  }

}
