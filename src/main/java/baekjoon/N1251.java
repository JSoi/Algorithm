package baekjoon;

import java.util.*;

public class N1251 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        System.out.println(createSeparateWords(input));
    }

    static String createSeparateWords(String input) {
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < input.length() - 2; i++) {
            String first = reverse(input.substring(0, i+1 ));
            for (int j = i + 1; j < input.length() - 1; j++) {
                String second = reverse(input.substring(i + 1, j + 1));
                String third = reverse(input.substring(j + 1));
                strings.add(first + second + third);
            }
        }
        Collections.sort(strings);
        return strings.get(0);
    }

    static String reverse(String input) {
        return new StringBuilder(input).reverse().toString();
    }
}
