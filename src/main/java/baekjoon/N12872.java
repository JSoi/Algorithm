package baekjoon;


import java.util.Scanner;

public class N12872 {
    private static final long DIVISOR = 1_000_000_007;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(); // 노래 종류
        int m = scan.nextInt(); // 사이 곡 수
        int p = scan.nextInt(); // 오늘 들을 노래
        scan.close();
        long[][] dp = new long[p + 1][n + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= p; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = (dp[i][j] + dp[i - 1][j - 1] * (n - j + 1)) % DIVISOR;
                if (j > m) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j] * (j - m)) % DIVISOR;
                }
            }
        }
        System.out.println(dp[p][n]);
    }
}
