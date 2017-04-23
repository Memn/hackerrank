package memn.hackerrank.bitmaniplation;

import java.util.Scanner;

/**
 * Created by Memn on 22.04.2017.
 */
public class SansaAndXor {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    for (int i = 0; i < t; i++) {
      int n = in.nextInt();
      int[] arr = new int[n];
      for (int j = 0; j < n; j++) {
        arr[j] = in.nextInt();
      }
      System.out.println(xorContiguousSubArrays(arr));
    }
  }

  private static int xorContiguousSubArrays(int[] arr) {
    // I need to count an index appears in a sub-array
    int ans = 0;
    for (int i = 0; i < arr.length; i++) {
      long times = (i + 1) * (arr.length - i);
      if (times % 2 == 1) {
        ans ^= arr[i];
      }
    }
    return ans;
  }

}
