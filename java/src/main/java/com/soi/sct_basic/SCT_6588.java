package com.soi.sct_basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SCT_6588 {
    static boolean[] prime;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        prime = new boolean[1000000 + 1];
        find();

        StringBuilder sb = new StringBuilder();
        while (true) {
            int num = Integer.parseInt(bf.readLine());
            if (num == 0)
                break;
            boolean flag = false;
            for (int i = num, temp = num - i; i >= temp; i--, temp = num - i) {
                if (!prime[i] && !prime[temp]) {
                    sb.append(num);
                    sb.append(" = ");
                    sb.append(temp);
                    sb.append(" + ");
                    sb.append(i);
                    sb.append("\n");
                    flag = true;
                    break;
                }
            }
            if (!flag)
                sb.append("Goldbach's conjecture is wrong.\n");
        }
        System.out.println(sb);

    }

    public static void find() {
        prime[0] = prime[1] = true;
        for (int i = 2; i <= 1000000; i++) {
            if (!prime[i]) {
                for (int j = i + i; j <= 1000000; j += i)
                    prime[j] = true;
            }
        }
    }
}
