package com.soi.programmers;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class POG_451808 {
    private List<String> candidates = new ArrayList<>();
    private int trial;
    public static void main(String[] args) {
        POG_451808 sample = new POG_451808();

        int secret = 1357;

        Function<Integer, String> submit = guess -> judge(secret, guess);
        int answer = sample.solution(20, submit);

        System.out.println("secret = " + secret);
        System.out.println("found  = " + answer);
    }
    private static String judge(int secret, int guess) {
        if (guess < 1000 || guess > 9999) {
            throw new IllegalArgumentException("guess must be 4-digit: " + guess);
        }

        String s = String.valueOf(secret);
        String g = String.valueOf(guess);

        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 4; i++) {
            if (g.charAt(i) == s.charAt(i)) strike++;
            else if (s.indexOf(g.charAt(i)) >= 0) ball++;
        }

        return strike + "S " + ball + "B";
    }

    // 전체 경우의 수 = 9*8*7*6 = 3024
    public int solution(int n, Function<Integer, String> submit) {
        permutation(new boolean[10], ""); // init
        while (trial++ < n) {
            String submitStr = candidates.stream().findAny().orElseThrow();
            int guess = Integer.parseInt(submitStr);
            String submitResult = submit.apply(guess);
            filter(submitStr, submitResult);
            if (submitResult.equals("4S 0B")) {
                return guess;
            }
        }
        return Integer.parseInt(candidates.get(0));
    }

    private void filter(String submitStr, String submitResult) {
        candidates.removeIf(c -> !mark(c, submitStr).equals(submitResult));
    }

    private static String mark(String candidate, String submitStr) {
        int strike = 0;
        int ball = 0;
        // standard : candidate
        for (int c = 0; c < 4; c++) { // strike
            if (candidate.charAt(c) == submitStr.charAt(c)) {
                strike++;
            } else {
                ball += candidate.indexOf(submitStr.charAt(c)) >= 0 ? 1 : 0;
            }
        }
        return String.format("%dS %dB", strike, ball);
    }

    public void permutation(boolean[] visit, String temp) {
        if (temp.length() == 4) {
            candidates.add(temp);
            return;
        }
        for (int i = 1; i < 10; i++) {
            if (visit[i]) {
                continue;
            }
            visit[i] = true;
            permutation(visit, temp + i);
            visit[i] = false;
        }
    }
}
