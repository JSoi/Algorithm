package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1039 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        int len = String.valueOf(N).length();

        HashMap<Integer, Set<String>> map = new HashMap<>();
        for (int i = 0; i <= K; i++) {
            map.put(i, new HashSet<>());
        }

        int answer = -1;
        Queue<Status> queue = new LinkedList<>();
        queue.offer(new Status(String.valueOf(N), 0));
        while (!queue.isEmpty()) {
            Status latest = queue.poll();
            String currentStr = latest.current;
            int currentCount = latest.count;

            if (currentCount == K) {
                answer = Math.max(answer, Integer.parseInt(currentStr));
                continue;
            }

            for (int i = 0; i < len; i++) {
                char temp = currentStr.charAt(i);
                for (int j = i + 1; j < len; j++) {
                    // 첫 자리수가 0이 되는 경우 스킵
                    if (i == 0 && currentStr.charAt(j) == '0') {
                        continue;
                    }
                    char[] toArr = currentStr.toCharArray();
                    toArr[i] = toArr[j];
                    toArr[j] = temp;
                    Set<String> nextSet = map.get(currentCount + 1);
                    String nextStr = String.valueOf(toArr);
                    if (!nextSet.contains(nextStr)) {
                        queue.offer(new Status(nextStr, currentCount + 1));
                        nextSet.add(nextStr);
                    }
                }
            }
        }
        System.out.println(answer);
    }

    private static class Status {
        String current;
        int count;

        public Status(String current, int count) {
            this.current = current;
            this.count = count;
        }
    }
}
