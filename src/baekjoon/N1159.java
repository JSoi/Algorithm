package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N1159 {
    private static final String LOSE = "PREDAJA";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        int[] countArr = new int['z' - 'a' + 1];
        for (int i = 0; i < count; i++) {
            String s = br.readLine();
            char sub = s.charAt(0);
            countArr[sub - 'a']++;
        }
        String answer = "";
        for (int i = 'a'; i <= 'z'; i++) {
            if (countArr[i - 'a'] >= 5) {
                answer = answer + (char) i;
            }
        }
        System.out.println(answer.isEmpty() ? LOSE : answer);
    }
}
