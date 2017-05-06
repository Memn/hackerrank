package memn.hackerrank.contests.hack101;

import java.util.Scanner;

/**
 * .
 * Created by Memn on 22.04.2017.
 */
public class Dreamplay {

  static String stringGameWinner(String s, String p) {
    // Complete this function
    // Amanda can win if and only if middle is p, then assume that middle is p
    // So,
    // CASE 1:
    // s=SpS
    // after m-1 moves where, S is a string with length m.
    // s = xpx
    // Steven plays
    // then Amanda wins
    // CASE 2:
    // s=SpaS
    // s=SapS
    // Amanda plays
    int rest = s.length() - p.length();
    if (rest < 1) {
      // Steven plays first.
      return "Steven";
    }
    if (rest % 2 == 0) {
      int start = rest / 2;
      return s.substring(start, start + p.length()).equals(p) ? "Amanda" : "Steven";
    } else {
      int start = rest / 2;
      if (s.substring(start, start + p.length()).equals(p)) {
        return "Amanda";
      } else if (s.substring(start + 1, start + 1 + p.length()).equals(p)) {
        return "Amanda";
      } else {
        return "Steven";
      }
    }

  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int q = in.nextInt();
    for (int a0 = 0; a0 < q; a0++) {
      String s = in.next();
      String p = in.next();
      String result = stringGameWinner(s, p);
      System.out.println(result);
    }
  }

}
