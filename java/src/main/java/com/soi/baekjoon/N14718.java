package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N14718 {
    private static int n, k;
    private static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tok = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(tok.nextToken());
        k = Integer.parseInt(tok.nextToken());
        arr = new int[n][3];
        int[] a = new int[n];
        int[] b = new int[n];
        int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            tok = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = a[i] = Integer.parseInt(tok.nextToken());
            arr[i][1] = b[i] = Integer.parseInt(tok.nextToken());
            arr[i][2] = c[i] = Integer.parseInt(tok.nextToken());
        }
        a = Arrays.stream(a).distinct().sorted().toArray();
        b = Arrays.stream(b).distinct().sorted().toArray();
        c = Arrays.stream(c).distinct().sorted().toArray();
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                for (int o = 0; o < c.length; o++) {
                    int count = 0;
                    for (int l = 0; l < n; l++) {
                        if (arr[l][0] <= a[i] && arr[l][1] <= b[j] && arr[l][2] <= c[o]) {
                            count++;
                        }
                    }
                    if (count >= k) {
                        answer = Math.min(answer, a[i] + b[j] + c[o]);
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
