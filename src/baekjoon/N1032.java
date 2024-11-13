package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N1032 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine()) - 1;
        char[] answer = br.readLine().toCharArray();
        while (count-- > 0) {
            char[] input = br.readLine().toCharArray();
            for (int i = 0; i < input.length; i++) {
                if (answer[i] != input[i]) {
                    answer[i] = '?';
                }
            }
        }
        System.out.println(String.valueOf(answer));

    }
}
