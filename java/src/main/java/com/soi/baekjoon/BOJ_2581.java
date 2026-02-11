package com.soi.baekjoon;

import java.util.Scanner;

public class BOJ_2581 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt(); // M<=N
        int n = scan.nextInt();
        scan.close();
        boolean[] p = new boolean[n + 1];
        p[0] = p[1] = false;
        for (int i = 2; i <= n; i++) {
            p[i] = true;
        }
        for (int i = 2; i * i <= n; i += 1) {
            for (int j = i * i; j <= n; j += i) {
                p[j] = false;
            }
        }
        int primehap = 0;
        int primemin = -1;
        int primecount = 0;
        for (int k = m; k <= n; k++) {
            if (p[k]) {
                if (primemin == -1)
                    primemin = k;
                primehap += k;
                primecount++;
            }
        }
        if (primecount == 0) {
            System.out.println(-1);
        } else {
            System.out.println(primehap);
            System.out.println(primemin);
        }
    }

}
