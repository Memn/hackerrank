package memn.hackerrank.datastructures.queues;

import java.util.Scanner;
import java.util.Stack;

/**
 * QueueUsingTwoStacks.
 * Created by Memn on 20.04.2017.
 */
public class QueueUsingTwoStacks {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    Stack<Integer> inbox = new Stack<>();
    Stack<Integer> outbox = new Stack<>();
    int q = in.nextInt();
    for (int i = 0; i < q; i++) {
      int type = in.nextInt();
      switch (type) {
        case 1:
          inbox.push(in.nextInt());
          break;
        case 2:
          refillOutbox(inbox, outbox);
          if (!outbox.isEmpty()) {
            outbox.pop();
          }
          break;
        case 3:
          refillOutbox(inbox, outbox);
          System.out.println(outbox.peek());
          break;
      }
    }
  }

  private static void refillOutbox(Stack<Integer> inbox, Stack<Integer> outbox) {
    if (outbox.isEmpty()) {
      while (!inbox.isEmpty()) {
        outbox.push(inbox.pop());
      }
    }
  }
}
