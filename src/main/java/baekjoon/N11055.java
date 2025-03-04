package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N11055 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n];
        int[] dp = new int[n];
        StringTokenizer tok = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(tok.nextToken());
        }
        if (n == 1) {
            System.out.println(num[0]);
            return;
        }
        dp[n - 1] = num[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            dp[i] = num[i];
            for (int j = i + 1; j < n; j++) {
                if (num[i] < num[j]) {
                    dp[i] = Math.max(dp[i], num[i] + dp[j]);
                }
            }
        }
        System.out.println(Arrays.stream(dp).max().orElse(0));
    }
}
