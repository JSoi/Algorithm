package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_1700 {
    private static int[] order;
    private static int n, k;
    private static int[][] pos;
    private static Set<Integer> plugs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        plugs = new HashSet<>(n);
        order = new int[k];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < k; i++) {
            order[i] = Integer.parseInt(st.nextToken());
        }
        int answer = 0;
        // initialize : pos[plug][idx]
        int[] plugPosition = new int[k + 1];
        pos = new int[k + 1][k];
        Arrays.fill(plugPosition, Integer.MAX_VALUE);
        for (int i = k - 1; i >= 0; i--) {
            int o = order[i];
            plugPosition[o] = i;
            for (int kk = 1; kk <= k; kk++) {
                pos[kk][i] = plugPosition[kk];
            }
        }
//        for (int[] p : pos) {
//            System.out.println(Arrays.toString(p));
//        }

        for (int i = 0; i < k; i++) {
            if (plugs.contains(order[i])) {
                continue;
            }
            if (plugs.size() >= n) {
                int eliminate = plugToEliminate(i);
                plugs.remove(eliminate);
                answer++;
            }
            plugs.add(order[i]);
        }
        System.out.println(answer);
    }


    private static int plugToEliminate(int currIdx) {
        int farthestPlug = 0;
        int farthestDist = -1;
        for (int p : plugs) {
            if (farthestDist < pos[p][currIdx]) {
                farthestPlug = p;
                farthestDist = pos[p][currIdx];
            }
        }
        return farthestPlug;
    }
}
