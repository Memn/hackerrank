package memn.hackerrank.datastructures.strings;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Strings: Making Anagrams from Cracking the coding interview.
 * Created by Memn on 29.04.2017.
 */
public class MakingAnagrams {

  public static int numberNeeded(String first, String second) {
    int[] charCount = new int[28];
    for (char c : first.toCharArray()) {
      charCount[c - 97]++;
    }
    for (char c : second.toCharArray()) {
      charCount[c - 97]--;
    }
    return Arrays.stream(charCount).map(Math::abs).sum();
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String a = in.next();
    String b = in.next();
    System.out.println(numberNeeded(a, b));
  }

}
