package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class N15663 {
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
        arr = Arrays.stream(arr).sorted().toArray();
        permutation(0, new boolean[arr.length], new int[R], arr);
    }

    private static void permutation(int aIdx, boolean[] visit, int[] answer, int[] arr) {
        if (aIdx >= answer.length) {
            String answerStr = Arrays.stream(answer).mapToObj(String::valueOf).collect(Collectors.joining(" "));
            System.out.println(answerStr);
            return;
        }
        int latest = 0;
        for (int i = 0; i < arr.length; i++) {
            if (!visit[i] && latest != arr[i]) {
                visit[i] = true;
                latest = arr[i];
                answer[aIdx] = arr[i];
                permutation(aIdx + 1, visit, answer, arr);
                visit[i] = false;
            }
        }
    }
}
