package com.soi.baekjoon;

import java.util.Scanner;

public class BOJ_15649 {
    static int num, count;
    static int[] selected;
    static boolean[] used;
    static StringBuilder sb = new StringBuilder();

    static void input() {
        Scanner scan = new Scanner(System.in);
        num = scan.nextInt();
        count = scan.nextInt();
        scan.close();
        selected = new int[count + 1];
        used = new boolean[num + 1];
    }

    static void choose(int k) {
        if (k == count + 1) {
            for (int i = 1; i <= count; i++) {
                sb.append(selected[i] + " ");
            }
            sb.append("\n");
        } else {
            for (int j = 1; j <= num; j++) {
                if (used[j]) {
                    continue;
                }
                selected[k] = j;
                used[j] = true;
                choose(k + 1);
                selected[k] = 0;
                used[j] = false;
            }
        }
    }

    public static void main(String[] args) {
        input();
        choose(1);
        System.out.println(sb.toString());
    }
}
