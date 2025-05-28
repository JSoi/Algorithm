package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class N1326 {
    static int[] bridge;
    static int[] count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        bridge = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] countArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int answer = jump(countArr[0] - 1, countArr[1] - 1);
        System.out.println(answer);
    }

    static int jump(int currentIdx, int targetIdx) {
        count = new int[bridge.length];
        Arrays.fill(count, Integer.MAX_VALUE);
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(currentIdx, 0));
        while (!queue.isEmpty()) {
            Node latest = queue.poll();
            if (latest.index == targetIdx) {
                return latest.jumpCount;
            }
            if (count[latest.index] != Integer.MAX_VALUE) {
                continue;
            }
            final int offset = bridge[latest.index];
            for (int r = latest.index + offset; r < count.length; r += offset) {
                queue.offer(new Node(r, latest.jumpCount + 1));
            }
            for (int l = latest.index - offset; l >= 0; l -= offset) {
                queue.offer(new Node(l, latest.jumpCount + 1));
            }
        }
        return -1;
    }

    static class Node {
        int index;
        int jumpCount;

        public Node(int index, int jumpCount) {
            this.index = index;
            this.jumpCount = jumpCount;
        }
    }
}
