package baekjoon;

import java.util.Scanner;

/**
 * <a href = "https://www.acmicpc.net/problem/1563">개근상</a>
 */
public class N1563 {
    private static final int MOD = 1_000_000;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int day = sc.nextInt();
        sc.close();
        long[][] dp = new long[day + 1][6];
        // 지각 0 결석 0 - 0
        // 지각 0 결석 1 - 1
        // 지각 0 결석 2 - 2
        // 지각 1 결석 0 - 3
        // 지각 1 결석 1 - 4
        // 지각 1 결석 2 - 5
        dp[0][0] = 1;
        for (int i = 1; i <= day; i++) {
            // 지각 0
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % MOD;
            dp[i][1] = dp[i - 1][0]; // 결석 1
            dp[i][2] = dp[i - 1][1]; // 결석 2

            // 지각 1
            dp[i][3] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][3] + dp[i - 1][4] + dp[i - 1][5]) % MOD;
            dp[i][4] = dp[i - 1][3]; // 지각 1 + 결석 1
            dp[i][5] = dp[i - 1][4]; // 지각 1 + 결석 2
        }

        long answer = 0;
        for (long val : dp[day]) {
            answer = (answer + val) % MOD;
        }
        System.out.println(answer);
    }
}
