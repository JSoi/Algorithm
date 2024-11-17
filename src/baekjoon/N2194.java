package baekjoon;

import java.util.Scanner;

public class N2194 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println(getNumber(scan.nextInt()));
    }

    private static long getNumber(int input) {
        if (input == 1) {
            return 1;
        }
        long[][] dp = new long[input][2];
        dp[0][1] = 1; // 1로 시작하는 경우만 존재
        for (int i = 1; i < input; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 1][1];
            dp[i][1] = dp[i - 1][0];
        }
        return dp[input - 1][1] + dp[input - 1][0];
    }
}
