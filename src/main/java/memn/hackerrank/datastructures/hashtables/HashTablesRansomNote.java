package memn.hackerrank.datastructures.hashtables;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

class HashTablesRansomNote {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        String magazine[] = new String[m];
        for (int magazine_i = 0; magazine_i < m; magazine_i++) {
            magazine[magazine_i] = in.next();
        }
        String ransom[] = new String[n];
        for (int ransom_i = 0; ransom_i < n; ransom_i++) {
            ransom[ransom_i] = in.next();
        }

        if (ransomNote(magazine, ransom)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    private static boolean ransomNote(String[] magazine, String[] ransom) {
        Map<String, Integer> dict = Arrays.stream(magazine)
            .collect(Collectors.toMap(s -> s, c -> 1, Integer::sum));
        System.out.println(dict.toString());

        Map<String, Integer> dict2 = Arrays.stream(ransom)
            .collect(Collectors.toMap(s -> s, c -> 1, Integer::sum));
        System.out.println(dict2);

        dict2.forEach((s, integer) -> dict.put(s, dict.getOrDefault(s, 0) - 1));
        System.out.println(dict.toString());

        return dict.values().stream().filter(integer -> integer < 0).count() > 0;
    }

}