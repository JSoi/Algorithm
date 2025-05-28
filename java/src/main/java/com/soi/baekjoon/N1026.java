package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N1026 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        int[] A = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::valueOf).sorted().toArray();
        int[] B = Arrays.stream(br.readLine().split(" "))
                .map(Integer::valueOf).sorted(((i1, i2) -> i2 - i1)
                ).mapToInt(Integer::intValue).toArray();
        int answer = 0;
        for (int i = 0; i < A.length; i++) {
            answer += A[i] * B[i];
        }
        System.out.println(answer);
    }
}
