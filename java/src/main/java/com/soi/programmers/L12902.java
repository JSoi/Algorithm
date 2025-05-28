package com.soi.programmers;

public class L12902 {
    public static void main(String[] args) {
//        int solution = new L12902().solution(5);
//        int solution2 = new L12902().solution(8);
//        System.out.println(solution);
//        System.out.println(solution2);
        System.out.println(new L12902().solution(4)); // 11
        System.out.println(new L12902().solution(6)); // 41
        System.out.println(new L12902().solution(8)); // 153
        System.out.println(new L12902().solution(10)); // 571
        System.out.println(new L12902().solution(12)); // 2131
        System.out.println(new L12902().solution(14)); // 7953
    }

    public int solution(int n) {
        if (n % 2 == 1) {
            return 0;
        }
        final long divisor = 1000000007L;
        long[] dp = new long[n+1];
        dp[2] = 3;
        long sum = 0;
        for (int garo = 4; garo <= n; garo += 2) {
            dp[garo] = (3 * dp[garo - 2] + 2 * sum + 2) % divisor;
            sum += dp[garo - 2] % divisor;
        }
        return (int) dp[n];
    }
}
