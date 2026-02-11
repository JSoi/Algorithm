package com.soi.baekjoon;

import java.io.*;

public class BOJ_10989 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] counting = new int[10001];
        int givenNumbers = Integer.parseInt(br.readLine());
        int max = 0;
        for (int i = 0; i < givenNumbers; i++) {
            int put = Integer.parseInt(br.readLine());
            if (max <= put) {
                max = put;
            }
            counting[put]++;
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 1; i <= max; i++) {
            for (int k = 0; k < counting[i]; k++) {
                bw.write(i + "\n");
            }
        }
        bw.flush();
    }
}
