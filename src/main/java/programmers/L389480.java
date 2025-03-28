package programmers;

import java.util.Arrays;

/**
 * <a href = "https://school.programmers.co.kr/learn/courses/30/lessons/389480">완전 범죄</a>
 */
public class L389480 {
    public static void main(String[] args) {
        System.out.println(new L389480().solution(new int[][]{{1, 2}, {2, 3}, {2, 1}}, 4, 4));
    }
    public static final int MAX = Integer.MAX_VALUE;
    public int solution(int[][] info, int n, int m) {
        int len = info.length;
        int[][][] dp = new int[len+1][n][m];
        for (int[][] d : dp) {
            for (int[] dd : d) {
                Arrays.fill(dd, MAX);
            }
        }

        dp[0][0][0] = 0;
        for (int i = 0; i < len ; i++) {
            for (int a = 0; a < n; a++) {
                for (int b = 0; b < m; b++) {
                    if (dp[i][a][b] == MAX) continue;
                    int newA = Math.min(n, a + info[i][0]);
                    if (newA < n)
                        dp[i + 1][newA][b] = Math.min(dp[i + 1][newA][b], dp[i][a][b] + info[i][0]);
                    int newB = Math.min(m, b + info[i][1]);
                    if (newB < m)
                        dp[i + 1][a][newB] = Math.min(dp[i + 1][a][newB], dp[i][a][b] + info[i][1]);
                }
            }
        }

        int answer = MAX;
        for (int a = 0; a < n; a++) {
            for (int b = 0; b < m; b++) {
                if (dp[len][a][b] != MAX) {
                    answer = Math.min(answer, a);
                }
            }
        }
        return answer == MAX ? -1 : answer;
    }

}
