package baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class N1343 {
    public static void main(String[] args) {
        String input = new Scanner(System.in).nextLine();
        ArrayList<String> strings = new ArrayList<>();
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (temp.length() == 0) {
                temp.append(c);
                continue;
            }
            if (temp.charAt(0) != c) {
                strings.add(temp.toString());
                temp = new StringBuilder(String.valueOf(c));
            } else {
                temp.append(c);
                if (i == input.length() - 1) {
                    strings.add(temp.toString());
                }
            }
        }
        StringBuilder answer = new StringBuilder();
        for (String s : strings) {
            if (s.charAt(0) == '.') {
                answer.append(s);
            } else {
                if (s.length() % 2 == 1) {
                    System.out.println(-1);
                    return;
                }
                answer.append("AAAA".repeat(s.length() / 4))
                        .append("BB".repeat(s.length() % 4 > 0 ? 1 : 0));
            }
        }
        System.out.println(answer);
    }
}
