package memn.hackerrank.graphs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

/**
 * Prim's Algorithm for Minimum Spanning Tree.
 * Created by Memn on 22.04.2017.
 */
public class PrimsMST {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int m = in.nextInt();

    int[][] graph = new int[n][n];
    for (int i = 0; i < m; i++) {
      int x = in.nextInt();
      int y = in.nextInt();
      int r = in.nextInt();
      graph[x][y] = r;
    }
    int s = in.nextInt();

    System.out.println(calculateMSTEdgeSum(graph, n, m, s));

  }

  private static int calculateMSTEdgeSum(int[][] graph, int n, int m, int s) {
    PriorityQueue<Vertex> vertices = new PriorityQueue<>();
    Set<Integer> mstIncluded = new HashSet<>();
    while (!mstIncluded.isEmpty()) {
    }
    return 0;
  }

  private static class Vertex {

  }
}
