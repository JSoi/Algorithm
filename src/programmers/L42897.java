package programmers;

import java.util.*;

public class L42897 {

    public static void main(String[] args) {
        int solution = new L42897().solution(new int[]{1, 2, 3, 1});
//        int solution2 = new L42897().solution(new int[]{1, 2, 3});
        System.out.println("solution = " + solution);
    }

    public int solution(int[] money) {
        int len = money.length;
        int[][] dp = new int[len][2];
        if (len <= 2) {
            return Arrays.stream(money).max().orElse(0);
        }
        dp[0][1] = dp[1][0] = money[0];
        for (int i = 2; i < dp.length - 1; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + money[i];
        }
        int withFirstHouse = Math.max(dp[len - 2][0], dp[len - 2][1]);
        Arrays.fill(dp[0], 0);
        Arrays.fill(dp[1], 0);
        dp[1][1] = money[1];
        for (int i = 2; i < dp.length - 1; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + money[i];
        }
        int withoutFirstHouse = Math.max(Math.max(dp[len - 2][0], dp[len - 2][1]), dp[len - 2][0] + +money[len - 1]);
        return Math.max(withoutFirstHouse, withFirstHouse);
    }
}
