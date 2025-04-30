package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * DP 문제
 */

public class N1324 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] firstTrashArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] secondTrashArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] dp = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int currentMax = 0;
            for (int j = 0; j < n; j++) {
                if (firstTrashArr[i] == secondTrashArr[j]) {
                    dp[j] = Math.max(dp[j], currentMax + 1);
                } else if (firstTrashArr[i] > secondTrashArr[j]) {
                    currentMax = Math.max(currentMax, dp[j]);
                }
            }
        }
        System.out.println(Arrays.stream(dp).max().orElse(0));
    }
}