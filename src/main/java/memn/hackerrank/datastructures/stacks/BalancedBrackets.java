package memn.hackerrank.datastructures.stacks;

import java.util.Scanner;
import java.util.Stack;

/**
 * BalancedBrackets.
 * Created by Memn on 20.04.2017.
 */
public class BalancedBrackets {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    for (int a0 = 0; a0 < t; a0++) {
      String s = in.next();
      System.out.println(isBracketsBalanced(s) ? "YES" : "NO");
    }
  }

  private static boolean isBracketsBalanced(String s) {
    Stack<Character> openingBrackets = new Stack<>();
    for (char c : s.toCharArray()) {
      if (!openingBrackets.isEmpty() && matches(openingBrackets.peek(), c)) {
        openingBrackets.pop();
      } else if (isOpeningBracket(c)) {
        openingBrackets.push(c);
      } else {
        return false;
      }
    }
    return openingBrackets.isEmpty();
  }

  private static boolean matches(Character opening, char closing) {
    switch (opening){
      case '[':
        return closing == ']';
      case '(':
        return closing == ')';
      case '{':
        return closing == '}';
    }
    return false;
  }

  private static boolean isOpeningBracket(char c) {
    switch (c){
      case '[':
      case '(':
      case '{':
        return true;
    }
    return false;
  }
}
