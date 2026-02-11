package com.soi.baekjoon;

import java.util.Scanner;

public class BOJ_12891 {
    static int s, p, check, answer;
    static int[] rule, myArr;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        s = scan.nextInt();
        p = scan.nextInt();
        scan.nextLine();
        String line = scan.nextLine();
        rule = new int[4];
        myArr = new int[4];
        check = answer = 0;
        rule[DNA.A.num] = scan.nextInt();
        rule[DNA.C.num] = scan.nextInt();
        rule[DNA.G.num] = scan.nextInt();
        rule[DNA.T.num] = scan.nextInt();
        for (int i = 0; i < 4; i++) {
            if (rule[i] == 0)
                check++;
        }
        for (int i = 0; i < p; i++) {
            add(giveDNA(line.charAt(i)));
        }
        if (check == 4) {
            answer++;
        }
        for (int i = p; i < s; i++) {
            int j = i - p;
            add(giveDNA(line.charAt(i)));
            remove(giveDNA(line.charAt(j)));
            if (check == 4) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    public static void add(DNA D) {
        int target = D.num;
        myArr[target]++;
        if (myArr[target] == rule[target]) {
            check++;
        }
    }

    public static void remove(DNA D) {
        int target = D.num;
        if (myArr[target] == rule[target]) {
            check--;
        }
        myArr[target]--;
    }

    static DNA giveDNA(char c) {
        switch (c) {
            case 'A':
                return DNA.A;
            case 'G':
                return DNA.G;
            case 'C':
                return DNA.C;
            case 'T':
                return DNA.T;
            default:
                break;
        }
        return null;
    }

    enum DNA {
        A(0, 'A'), C(1, 'C'), G(2, 'G'), T(3, 'T');

        private final int num;
        private char a;

        DNA(int i) {
            this.num = i;
        }

        DNA(int i, char a) {
            this.num = i;
            this.a = a;
        }
    }
}
