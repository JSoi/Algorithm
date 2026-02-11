package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <a href = "https://www.acmicpc.net/problem/1239">차트</a>
 */
public class BOJ_1239 {
    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[][] status;
    private static int N;
    private static int answer;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        Map<Integer, Integer> frequencyMap = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt)
                .collect(Collectors.toMap(k -> k, k -> 1, Integer::sum));
        status = frequencyMap.entrySet().stream().map(e -> new int[]{e.getKey(), e.getValue()}).toArray(int[][]::new);
        permute(0, new int[N]);
        System.out.println(answer);
    }

    private static void permute(int count, int[] arr) {
        if (count == N) {
            answer = Math.max(answer, countLines(arr));
            return;
        }
        for (int i = 0; i < status.length; i++) {
            if (status[i][1] == 0) {
                continue;
            }
            status[i][1]--;
            arr[count] = status[i][0];
            permute(count + 1, arr);
            status[i][1]++;
        }
    }

    private static int countLines(int[] percentageArr) {
        HashSet<Integer> cumulativePercentageSet = new HashSet<>();
        int cumulatePercentage = 0;
        for (int percentage : percentageArr) {
            cumulatePercentage += percentage;
            cumulativePercentageSet.add(cumulatePercentage);
        }
        int count = 0;
        for (int cp : cumulativePercentageSet) {
            if (cumulativePercentageSet.contains(cp + 50)) {
                count++;
            }
        }
        return count;
    }
}
