package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class BOJ_1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        int queueLen = nm[0];
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= queueLen; i++) {
            queue.offer(i);
        }
        int[] target = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        int answer = 0;
        for (int t : target) {
            int pos = queue.indexOf(t);
            if (pos <= queue.size() / 2) {
                for (int i = 0; i < pos; i++) {
                    queue.offer(queue.poll());
                    answer++;
                }
            } else {
                for (int i = 0; i < queue.size() - pos; i++) {
                    queue.offerFirst(queue.pollLast());
                    answer++;
                }
            }
            queue.poll();

        }
        System.out.println(answer);
    }
}
