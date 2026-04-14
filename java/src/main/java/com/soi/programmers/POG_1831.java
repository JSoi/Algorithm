package com.soi.programmers;

public class POG_1831 {
    public static void main(String[] args) {
        int solution = solution(15);
        System.out.println("solution = " + solution);
    }

    public static int solution(int n) {
        int answer = 0;
        int[] dp = new int[n + 1];
        // 가능 패턴 : *++, *+*++, *+*+*++++++++
//        dp[5][0] = 1; // *++
//        dp[6][0] = dp[5][0] + dp[6/3][1]; //
//        dp[7][0] = dp[6][0] + dp[(7-2)/3][1];

        // 마지막 * 뒤에 2개 이상 + 섞였는지
        // * 사이에 + 가 하나 이상 있는지
        // 연산 결과가 n인지 체크

        // n ==4
        // 1 : +
        // 2 : ++
        // 3 : *
        // 4 : *+
        // 5 : *++
        // 6 : *++++
        // 7 : *+++++
        // 8 : *++++++
        // 9 : *+++++++
        // 10 : *+++++++
        // 14 : *+*++, *+++++++++++++
        // 15 : *+*+++, *++++++++++++++
        // *++*++ = 17

        dp[5] = 0;
//        for (int i = 4; i <= n; i++) {
//            dp[i][0] += dp[i - 1][1];
//
//        }
        System.out.println(dp[n]);
        return answer;
    }
//    private static int dfs(int currVal, int lastThreeIdx, )
}
