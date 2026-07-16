package com.soi.programmers;

/**
 * <a href = "https://school.programmers.co.kr/learn/courses/30/lessons/86053">금과 은 운반하기</a>
 */
public class POG_86053 {
    private int totalGold, totalSilver, n;
    private int[] golds, silvers, weight, time;

    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        this.totalGold = a;
        this.totalSilver = b;
        this.golds = g;
        this.silvers = s;
        this.weight = w;
        this.time = t;
        this.n = g.length;
        return findTime();
    }

    private boolean possible(long t) {
        long g = 0;
        long s = 0;
        long m = 0;
        for (int i = 0; i < n; i++) {
            if (time[i] > t) continue;
            long round = (t + time[i]) / (2L * time[i]);
            round = Math.min(round, 2_000_000_000L);
            long totalWeight = round * weight[i];
            g += Math.min(totalWeight, golds[i]);
            s += Math.min(totalWeight, silvers[i]);
            m += Math.min(totalWeight, (long) golds[i] + silvers[i]);
            if (g >= totalGold && s >= totalSilver && m >= totalGold + totalSilver) return true;
        }
        return g >= totalGold && s >= totalSilver && m >= totalGold + totalSilver;
    }

    private long findTime() {
        long l = 0;
        long r = 1_000_000_000_000_000L * 4;
        while (l < r) {
            long mid = (l + r) / 2;
            if (possible(mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
