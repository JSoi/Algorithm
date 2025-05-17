package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class N1660 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n + 1];
        final int MAX = Integer.MAX_VALUE;
        Arrays.fill(dp, MAX);
        dp[0] = 0;
        int max = 130;
        int[] tetrahedron = new int[max];
        int[] triangle = new int[max];

        for (int i = 1; i < max; i++) {
            triangle[i] = i + triangle[i - 1];
            tetrahedron[i] = tetrahedron[i - 1] + triangle[i];
            int t = tetrahedron[i];
            if (tetrahedron[i] <= n) {
                dp[t] = 1;
                for (int j = t; j <= n; j++) {
                    if (dp[j - t] == MAX) {
                        continue;
                    }
                    dp[j] = Math.min(dp[j], dp[t] + dp[j - t]);
                }
            }
        }
        System.out.println(dp[n]);
    }
}
