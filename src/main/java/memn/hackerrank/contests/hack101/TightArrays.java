package memn.hackerrank.contests.hack101;

import java.util.Scanner;

/**
 * Created by Memn on 22.04.2017.
 */
public class TightArrays {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int a = in.nextInt();
    int b = in.nextInt();
    int c = in.nextInt();

    int length = Math.abs(a - b) + Math.abs(c - b) + 1;
    System.out.println(length);
  }

}
