package com.soi.programmers;

import java.util.ArrayList;
import java.util.List;

public class POG_135807 {
    public static void main(String[] args) {
        int solution = new POG_135807().solution(new int[]{10, 17}, new int[]{5, 20});
        int solution2 = new POG_135807().solution(new int[]{10, 20}, new int[]{5, 17});
        int solution3 = new POG_135807().solution(new int[]{14, 35, 119}, new int[]{18, 30, 102});
        System.out.println(solution);
        System.out.println(solution2);
        System.out.println(solution3);
    }

    public int solution(int[] arrayA, int[] arrayB) {
        return Math.max(solve(arrayA, arrayB), solve(arrayB, arrayA));
    }

    private int solve(int[] arrayA, int[] arrayB) {
        List<Integer> answer = getYaksu(arrayA[0]);
        for (int i = 1; i < arrayA.length; i++) {
            if (answer.isEmpty()) {
                return 0;
            }
            int finalI = i;
            answer.removeIf(a -> arrayA[finalI] % a != 0);
        }
        for (int i : arrayB) {
            answer.removeIf(a -> i % a == 0);
        }
        return answer.isEmpty() ? 0 : answer.get(answer.size() - 1);
    }

    public List<Integer> getYaksu(int input) {
        ArrayList<Integer> yaksu = new ArrayList<>();
        for (int i = 1; i <= input; i++) {
            if (input % i == 0) {
                yaksu.add(i);
            }
        }
        return yaksu;
    }
}
