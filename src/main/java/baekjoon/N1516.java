package baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class N1516 {
    static int[] dp;
    static HashMap<Integer, Set<Integer>> connMap;
    static int[] cost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        cost = new int[N + 1];
        dp = new int[N + 1];
        connMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            connMap.put(i + 1, new HashSet<>());
            cost[i + 1] = Integer.parseInt(line[0]);
            for (int j = 1; j < line.length - 1; j++) {
                connMap.get(i + 1).add(Integer.parseInt(line[j]));
            }
        }
        Arrays.fill(dp, -1);
        for (int i = 1; i <= N; i++) {
            bw.append(String.valueOf(findMinTime(i))).append("\n");
        }
        bw.flush();

    }

    static int findMinTime(int start) {
        if (dp[start] != -1) return dp[start];
        int priorBuildingTimeSum = 0;
        for (int priorBuilding : connMap.get(start)) {
            priorBuildingTimeSum = Math.max(priorBuildingTimeSum, findMinTime(priorBuilding));
        }
        return dp[start] = cost[start] + priorBuildingTimeSum;
    }
}
