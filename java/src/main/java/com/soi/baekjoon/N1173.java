package com.soi.baekjoon;

import java.util.Scanner;
import java.util.StringTokenizer;

public class N1173 {
    public static void main(String[] args) {
        String input = new Scanner(System.in).nextLine();
        StringTokenizer tok = new StringTokenizer(input, " ");
        int workTime = Integer.parseInt(tok.nextToken());
        int current = Integer.parseInt(tok.nextToken());
        int max = Integer.parseInt(tok.nextToken());
        int up = Integer.parseInt(tok.nextToken());
        int down = Integer.parseInt(tok.nextToken());
        if (current + up > max) {
            System.out.println(-1);
            return;
        }
        int answer = 0;
        int c = current;
        while (workTime > 0) {
            if (c + up > max) {
                c = Math.max(current, c - down);
                answer++;
            } else {
                int time = Math.min((max - c) / up, workTime);
                workTime -= time;
                c += time * up;
                answer += time;
            }
        }
        System.out.println(answer);
    }
}
