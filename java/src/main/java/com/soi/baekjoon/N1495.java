package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N1495 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tok = new StringTokenizer(br.readLine(), " ");
        int volumeCount = Integer.parseInt(tok.nextToken());
        int startVolume = Integer.parseInt(tok.nextToken());
        int maxVolume = Integer.parseInt(tok.nextToken());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        boolean[] dp = new boolean[maxVolume + 1];
        dp[startVolume] = true;
        for (int i = 0; i < volumeCount; i++) {
            int volumeChange = arr[i];
            boolean[] nextDp = new boolean[maxVolume + 1];
            for (int v = 0; v <= maxVolume; v++) {
                if (dp[v]) {
                    if (v + volumeChange <= maxVolume) {
                        nextDp[v + volumeChange] = true;
                    }
                    if (v - volumeChange >= 0) {
                        nextDp[v - volumeChange] = true;
                    }
                }
            }
            dp = nextDp;
        }

        for (int v = maxVolume; v >= 0; v--) {
            if (dp[v]) {
                System.out.println(v);
                return;
            }
        }
        System.out.println(-1);
    }
}
