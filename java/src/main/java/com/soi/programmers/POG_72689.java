package com.soi.programmers;

public class POG_72689 {
    public int solution(int n) {
        int starCount = countStar(n);
        return solve(starCount, starCount * 2 - 2, n - 2);
    }

    private int solve(int times, int plus, int currentValue) {
        if (currentValue == 3) {
            return (times == 1 && plus == 0) ? 1 : 0;
        }
        if (plus > times * 2 || currentValue < 3) return 0;
        int answer = 0;
        if (times > 0 && currentValue % 3 == 0)
            answer += solve(times - 1, plus, currentValue / 3);
        if (plus > 0)
            answer += solve(times, plus - 1, currentValue - 1);
        return answer;
    }

    private int countStar(int n) {
        // 3^n + 2*n
        int star = 0;
        while (n/3 >0) {
            n/=3;
            star++;
        }
        return star;
    }
}
