package com.soi.baekjoon;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1963 {
    public static final int MAX = 10000;
    private static boolean[] isPrime;

    public static void main(String[] args) throws IOException {
        initPrime();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int count = bfs(from, to);
            if (count == -1) {
                bw.write("Impossible\n");
            } else {
                bw.write(count + "\n");
            }
        }
        bw.flush();
    }

    private static int bfs(int from, int to) {
        boolean[] visit = new boolean[MAX];
        Queue<int[]> queue = new ArrayDeque<>();
        visit[from] = true;
        queue.add(new int[]{from, 0});
        while (!queue.isEmpty()) {
            int[] currArr = queue.poll();
            int curr = currArr[0];
            int currCount = currArr[1];
            if (curr == to) {
                return currArr[1];
            }
            for (int digit = 0; digit < 4; digit++) { // from min to max
                int mul = (int) Math.pow(10, digit);
                int currDigit = (curr / mul) % 10;

                int without = curr - (mul * currDigit);
                for (int i = 0; i < 10; i++) {
                    int nextNum = without + (mul * i);
                    if (visit[nextNum] || nextNum < 1000 || !isPrime[nextNum]) continue;
                    visit[nextNum] = true;
                    queue.add(new int[]{nextNum, currCount + 1});
                }

            }
        }
        return -1;
    }

    private static void initPrime() {
        isPrime = new boolean[MAX];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i < MAX; i++) {
            for (int j = 2; i * j < MAX; j++) {
                isPrime[i * j] = false;
            }
        }
    }
}
