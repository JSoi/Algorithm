package com.soi.baekjoon;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class N11729 {
    static int n;
    static List<int[]> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        init();
        hanoi(n, 1, 3, 2);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.append(String.valueOf(answer.size())).append("\n");
        for (int[] a : answer) {
            bw.append(a[0] + " " + a[1]).append("\n");
        }
        bw.flush();
    }

    static void init() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
    }

    static void hanoi(int n, int from, int to, int via) {
        if (n == 1) {
            answer.add(new int[]{from, to});
            return;
        }
        hanoi(n - 1, from, via, to);
        answer.add(new int[]{from, to});
        hanoi(n - 1, via, to, from);
    }

}
