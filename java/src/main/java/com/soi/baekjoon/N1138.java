package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class N1138 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        int[] answer = new int[count];
        int[] inputArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.fill(answer, -1);
        for (int i = 0; i < inputArr.length; i++) {
            int biggerCount = inputArr[i];
            int idx;
            int bc = biggerCount;
            for (idx = 0; idx < answer.length; idx++) {
                if (bc == 0 && answer[idx] == -1) {
                    break;
                }
                if (answer[idx] == -1) {
                    bc--;
                }
            }
            answer[idx] = i + 1;
        }
        System.out.println(Arrays.stream(answer).mapToObj(String::valueOf)
                .collect(Collectors.joining(" ")));
    }
}
