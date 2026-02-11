package com.soi.baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1174 {
    public static void main(String[] args) {
        int n = Integer.parseInt(new Scanner(System.in).nextLine());
        Queue<Long> queue = new LinkedList<>();
        for (long i = 0; i <= 9; i++) {
            queue.offer(i);
        }
        long localN = 1;
        while (!queue.isEmpty()) {
            long poll = queue.poll();
            if (localN == n) {
                System.out.println(poll);
                return;
            }
            localN++;
            for (int i = 0; i < poll % 10; i++) {
                queue.offer(poll * 10 + i);
            }
        }
        System.out.println(-1);
    }

}
