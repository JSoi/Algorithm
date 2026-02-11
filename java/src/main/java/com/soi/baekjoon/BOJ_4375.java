package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_4375 {
    public static void main(String[] args) throws IOException {

        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = null;
        int len = 0;
        while ((str = buf.readLine()) != null) {
            int n = Integer.parseInt(str);
            long val = 1;
            len = 1;
            while (true) {
                if (val % n == 0) {
                    break;
                }
                val = (val * 10) + 1;
                len++;
            }
            sb.append(len + "\n");
        }
        System.out.println(sb);
    }

}
