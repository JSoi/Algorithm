package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class N15666 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int arrayLength = Integer.parseInt(st.nextToken());
        int pickCount = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        arr = Arrays.stream(arr).distinct().sorted().toArray();
        repetitionPermutation(0, 0, arr, new int[pickCount]);
    }

    private static void repetitionPermutation(int idx, int answerIdx, int[] arr, int[] answer) {
        if (idx >= arr.length) {
            return;
        }
        if (answerIdx >= answer.length) {
            System.out.println(Arrays.stream(answer).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
            return;
        }
        for (int i = idx; i < arr.length; i++) {
            answer[answerIdx] = arr[i];
            repetitionPermutation(i, answerIdx + 1, arr, answer);
        }
    }
}
