package baekjoon;

import java.io.*;

public class N10844 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(longestStair(Integer.parseInt(br.readLine()))));
        bw.flush();
    }

    public static long longestStair(int n) {
        long[][] dp = new long[n][10];
        for (int i = 1; i < 10; i++) {
            dp[0][i] = 1;
        }
        for (int i = 0; i < n - 1; i++) {
            for (int c = 0; c < 10; c++) {
                if (c - 1 >= 0) {
                    dp[i + 1][c - 1] = (dp[i + 1][c - 1] + dp[i][c]) % 1000000000;
                }
                if (c + 1 < 10) {
                    dp[i + 1][c + 1] = (dp[i + 1][c + 1] + dp[i][c]) % 1000000000;
                }
            }
        }
        long answer = 0;
        for (int i = 0; i < 10; i++) {
            answer = (answer + dp[n - 1][i]) % 1000000000;
        }
        return answer;
    }
}
