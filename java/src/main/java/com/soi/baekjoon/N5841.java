package com.soi.baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class N5841 {
    static int N, K;
    static List<Relation> relations = new ArrayList<>();
    static int[] breed;
    static int count = 0;

    static class Relation {
        boolean same; // true - 'S', false - 'D'
        int a, b;

        Relation(boolean same, int a, int b) {
            this.same = same;
            this.a = a;
            this.b = b;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        breed = new int[N + 1];

        for (int i = 0; i < K; i++) {
            String type = sc.next();
            int a = sc.nextInt();
            int b = sc.nextInt();
            relations.add(new Relation(type.equals("S"), a, b));
        }

        dfs(1);
        System.out.println(count);
    }

    static void dfs(int idx) {
        if (idx > N) {
            if (check()) count++;
            return;
        }

        for (int i = 0; i < 3; i++) {
            breed[idx] = i;
            dfs(idx + 1);
        }
    }

    static boolean check() {
        for (Relation r : relations) {
            if (r.same && breed[r.a] != breed[r.b]) return false;
            if (!r.same && breed[r.a] == breed[r.b]) return false;
        }
        return true;
    }
}
