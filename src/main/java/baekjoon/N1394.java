package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N1394 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String givenPasswordChar = br.readLine();
        String password = br.readLine();
        if (password.length() == 1) {
            System.out.println(givenPasswordChar.indexOf(password.charAt(0)) + 1);
            return;
        }
        long answer = 0;
        for (int i = 0; i < password.length() - 1; i++) {
            long val = 1;
            for (int j = 0; j <= i; j++) {
                val = (val * givenPasswordChar.length()) % 900528;
            }
            answer += val;
            answer %= 900528;
        }
        long attempt = 1;
        for (int i = 0; i < password.length(); i++) {
            int k = givenPasswordChar.indexOf(password.charAt(i)) + 1;
            attempt = (attempt * k) % 900528;
        }
        answer += attempt;
        System.out.println(answer);
    }
}
