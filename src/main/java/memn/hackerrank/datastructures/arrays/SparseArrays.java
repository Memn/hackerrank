package memn.hackerrank.datastructures.arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * SparseArrays.
 * Created by Memn on 17.04.2017.
 */
public class SparseArrays {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String[] lines = getWords(scanner);
    String[] queries = getWords(scanner);
    Map<String, Integer> countMap = countOnMap(lines);
    for (String query : queries) {
      System.out.println(countMap.getOrDefault(query, 0));
    }

  }

  private static Map<String, Integer> countOnMap(String[] lines) {
    Map<String, Integer> countMap = new HashMap<>();
    for (String line : lines) {
      if (countMap.containsKey(line)) {
        countMap.put(line, countMap.get(line) + 1);
      } else {
        countMap.put(line, 1);
      }
    }
    return countMap;
  }

  private static String[] getWords(Scanner scanner) {
    int n = scanner.nextInt();
    scanner.nextLine();
    String[] lines = new String[n];
    for (int i = 0; i < n; i++) {
      lines[i] = scanner.nextLine();
    }
    return lines;
  }

}
