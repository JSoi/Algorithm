package baekjoon;

import java.util.HashSet;
import java.util.Scanner;

public class N1111 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        scan.close();
        HashSet<Pair> pairs = new HashSet<>();
        if (arr.length < 2) {
            System.out.println("A");
            return;
        }
        // init
        int a = arr[0];
        int b = arr[1];
        for (int i = -100; i <= 100; i++) {
            for (int j = -100; j <= 100; j++) {
                if (i * a + j == b) {
                    pairs.add(new Pair(i, j));
                }
            }
        }
        for (int k = 2; k < n; k++) {
            int aa = arr[k - 1];
            int bb = arr[k];
            pairs.removeIf(pair -> pair.a * aa + pair.b != bb);
            if (pairs.isEmpty()) {
                System.out.println("B");
                return;
            }
        }
        HashSet<Integer> answerSet = new HashSet<>();

            int lastE = arr[arr.length - 1];
        for (Pair pair : pairs) {
            answerSet.add(pair.a * lastE + pair.b);
        }
        if (answerSet.size() > 1) {
            System.out.println("A");
        } else {
            System.out.println(answerSet.stream().findFirst().get());
        }

    }

    private static class Pair {
        int a;
        int b;

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return a == pair.a && b == pair.b;
        }

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}
