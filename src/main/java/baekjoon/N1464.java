package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N1464 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        StringBuilder ans = new StringBuilder(str.substring(0, 1));

        for (int i = 1; i < str.length(); i++) {
            if (ans.charAt(0) >= str.charAt(i)) {
                ans.insert(0, str.charAt(i));
            } else {
                ans.append(str.charAt(i));
            }
        }
        System.out.println(ans);
    }
}
