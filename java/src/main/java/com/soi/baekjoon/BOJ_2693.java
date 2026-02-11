package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2693 {

    public static void main(String[] args) throws IOException {

        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int cnt = Integer.parseInt(buf.readLine());
        for (int i = 0; i < cnt; i++) {
            String line = buf.readLine();
            int[] arr = new int[10];
            for (int k = 0; k < 10; k++) {
                arr[k] = Integer.parseInt(line.split(" ")[k]);
            }
            Arrays.sort(arr);
            sb.append(arr[7] + "\n");
        }
        System.out.println(sb);
    }

}
