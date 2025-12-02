package com.soi.programmers;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class L12920 {
    public static void main(String[] args) {
        System.out.println(new L12920().solution(6, new int[]{1, 2, 3}));
    }

    public int solution(int n, int[] cores) {
        int answer = 0;
        // {coretype, endtime, workNo}
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x[1]));
        TreeSet<Integer> candidates = new TreeSet<>();
        int cLen = cores.length;
        for (int i = 0; i < cores.length; i++) {
            candidates.add(i);
        }
        int workloadNo = 0; // [0, 50,000]
        int currentTime = 0;
        while (workloadNo < n) {
            while (pq.size() < cLen && workloadNo < n) { // 적재
                int i = candidates.pollFirst();
                pq.offer(new int[]{i, currentTime + cores[i], workloadNo++});
            }
            currentTime = pq.peek()[1];
            while (!pq.isEmpty() && pq.peek()[1] == currentTime) {
                int[] next = pq.poll();
                if (next[2] == n - 1) {
                    return next[0] + 1;
                }
                candidates.add(next[0]);
            }
        }
        // left
        while (!pq.isEmpty()) {
            int[] next = pq.poll();
            if (next[2] == n - 1) {
                return next[0] + 1;
            }
        }
        return answer;
    }
}
