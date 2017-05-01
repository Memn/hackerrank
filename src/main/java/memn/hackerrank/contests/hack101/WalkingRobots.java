package memn.hackerrank.contests.hack101;

import java.util.Scanner;

/**
 * Created by Memn on 22.04.2017.
 */
public class WalkingRobots {

  static int howManyCollisions(String s) {
    // Complete this function
    int collisions = 0;
    int goesRight = 0;
    boolean stoppingOnLeft = false;

    for (char c : s.toCharArray()) {
      if (c == 'r') {
        goesRight++;
        stoppingOnLeft = false;
      } else if (c == 'l') {
        if (goesRight != 0) {
          collisions += goesRight;
          collisions++;
          goesRight = 0;
          stoppingOnLeft = true;
        } else if (stoppingOnLeft) {
          collisions++;
          stoppingOnLeft = true;
        }
      } else if (c == 'd') {
        collisions += goesRight;
        goesRight = 0;
        stoppingOnLeft = true;
      }
    }

    return collisions;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int q = in.nextInt();
    for (int a0 = 0; a0 < q; a0++) {
      String s = in.next();
      // Returns the number of times moving robots collide.
      int result = howManyCollisions(s);
      System.out.println(result);
    }
  }
}
