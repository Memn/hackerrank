package memn.hackerrank.datastructures.tries;

import java.util.Scanner;

/**
 * Tries: Contacts from Cracking the coding interview.
 * Created by Memn on 29.04.2017.
 */
public class Contacts {

    private boolean hasOne = false;
    private Contacts[] contacts;
    private int count;

    Contacts() {
        contacts = new Contacts[26];
        count = 0;
    }

    public static void main(String[] args) {
        Contacts contacts = new Contacts();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int a0 = 0; a0 < n; a0++) {
            String op = in.next();
            String contact = in.next();
            int operate = contacts.operate(op, contact);
            if (operate != -1) {
                System.out.println(operate);
            }
        }
    }


    private int operate(String op, String contact) {
        if (op.equals("add")) {
            add(contact);
        } else if (op.equals("find")) {
            return find(contact);
        }
        return -1;
    }


    int find(String str) {
        boolean has = hasOne;
        if (str.length() == 0) {
            return count + (has ? 1 : 0);
        } else {
            Contacts nextLetter = contacts[index(str.charAt(0))];
            return nextLetter == null ? 0 : nextLetter.find(str.substring(1));
        }
    }

    void add(String contact) {
        if (contact.length() == 0) {
            hasOne = true;
        } else {
            count++;
            char first = contact.charAt(0);
            // navigate to letter
            Contacts c = contacts[index(first)];
            if (c == null) {
                c = new Contacts();
                contacts[index(first)] = c;
            }
            c.add(contact.substring(1));
        }
    }

    private int index(char c) {
        return c - 97;
    }


}
