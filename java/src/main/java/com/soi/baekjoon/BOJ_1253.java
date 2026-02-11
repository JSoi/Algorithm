package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1253 {

    public static void main(String[] args) throws IOException {

        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(buf.readLine());
        long[] num = new long[cnt];
        int answer = 0;
        StringTokenizer tok = new StringTokenizer(buf.readLine());
        for (int i = 0; i < cnt; i++) {
            num[i] = Long.parseLong(tok.nextToken());
        }
        Arrays.sort(num);
        for (int i = 0; i < cnt; i++) {
            long find = num[i];
            int s = 0, e = cnt - 1;
            while (s < e) {
                if (num[s] + num[e] == find) {
                    if (s != i && e != i) {
                        answer++;
                        break;
                    } else if (s == i) {
                        s++;
                    } else if (e == i) {
                        e--;
                    }
                } else if (num[s] + num[e] < find) {
                    s++;
                } else {
                    e--;
                }
            }
        }
        System.out.println(answer);
    }

}
