package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N2751 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        int[] array = new int[cnt];
        for (int i = 0; i < cnt; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(array);
        StringBuilder buf = new StringBuilder();
        for(int a : array){
            buf.append(a+"\n");
        }
        System.out.println(buf);
    }
}
