package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N2750 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        int[] array = new int[cnt];
        for (int i = 0; i < cnt; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(array);
        Arrays.stream(array).forEach(System.out::println);
    }
}
