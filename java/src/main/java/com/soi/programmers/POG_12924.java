package com.soi.programmers;

public class POG_12924 {

    public static void main(String[] args) {

        System.out.println(solution(15));
    }

    static int solution(int n) {
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int hap = 0;
            for (int j = i; j <= n && hap <= n; j++) {
                hap += j;
                if (hap == n) {
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }
}
