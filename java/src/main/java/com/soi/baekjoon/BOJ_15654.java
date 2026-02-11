package com.soi.baekjoon;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class BOJ_15654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tok = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(tok.nextToken());
        int R = Integer.parseInt(tok.nextToken());
        int[] arr = new int[N];
        tok = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(tok.nextToken());
        }
        Arrays.sort(arr);
        permutation(0, new int[R], new boolean[arr.length], arr);
    }

    private static void permutation(int aIdx, int[] answer, boolean[] visitArr, int[] arr) {
        if (aIdx >= answer.length) {
            System.out.println(Arrays.stream(answer).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (!visitArr[i]) {
                answer[aIdx] = arr[i];
                visitArr[i] = true;
                permutation(aIdx + 1, answer, visitArr, arr);
                visitArr[i] = false;
            }
        }
    }
}
