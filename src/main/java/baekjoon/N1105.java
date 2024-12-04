package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N1105 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input =br.readLine().split(" ");
        String start = input[0];
        String end = input[1];
        if (start.length() != end.length()) {
            System.out.println(0);
            return;
        }
        int answer = 0;
        for (int c = 0; c < start.length() && start.charAt(c) == end.charAt(c); c++) {
            if (start.charAt(c) == '8') {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
