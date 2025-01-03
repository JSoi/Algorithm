package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N1092 {
    static int[][] dp;
    static int[][] price;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        price = new int[N][N];
        for (int i = 0; i < N; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                price[i][j] = line[j] - '0';
            }
        }
        dp = new int[1 << N][N + 1];
        System.out.println(dfs(0, 0, 0) + 1);
    }

    static int dfs(int owner, int currentPrice, int state) {
        state |= 1 << owner;
        if (dp[state][owner] > 0) {
            return dp[state][owner];
        }
        for (int next = 0; next < N; next++) {
            if ((state & (1 << next)) == 0 && price[owner][next] >= currentPrice) {
                dp[state][owner] = Math.max(dp[state][owner], dfs(next, price[owner][next], state) + 1);
            }
        }
        return dp[state][owner];
    }
}
