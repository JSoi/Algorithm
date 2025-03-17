package baekjoon;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class N1464 {
    private static Set<String> strSet;
    private static HashSet<String>[] visited;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        strSet = new HashSet<>();
        visited = new HashSet[input.length() + 1];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = new HashSet<>();
        }
        add(input, 0);
        System.out.println(strSet.stream().sorted().findFirst().orElse(""));
    }

    private static void add(String str, int index) {
        if (visited[index].contains(str)) {
            return;
        }
        visited[index].add(str);
        strSet.add(str);
        for (int i = index; i < str.length(); i++) {
            String reversed = reverseUntil(str, i + 1);
            add(reversed, i + 1);
        }
    }

    private static String reverseUntil(String str, int index) {
        StringBuilder sb = new StringBuilder(str.substring(0, index)).reverse();
        return sb.append(str.substring(index)).toString();
    }
}
