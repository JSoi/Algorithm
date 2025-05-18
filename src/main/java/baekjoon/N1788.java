package baekjoon;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class N1788 {
    static Map<Integer, Long> map = new HashMap<>();
    static final long MOD = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        int n = new Scanner(System.in).nextInt();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        if (n == 0) {
            bw.append("0\n0");
            bw.flush();
            return;
        }

        map.put(0, 0L);
        map.put(1, 1L);
        long fibonacci = getFibonacci(n);
//        System.out.println(map);
        bw.append(fibonacci < 0 ? "-1" : "1").append("\n");
        bw.append(String.valueOf(Math.abs(fibonacci)));
        bw.flush();
    }

    private static long getFibonacci(int n) {
        if (map.containsKey(n)) return map.get(n);
        long val;
        if (n < 0) {
            val = (getFibonacci(n + 2) - getFibonacci(n + 1)) % MOD;
        } else {
            val = (getFibonacci(n - 1) + getFibonacci(n - 2)) % MOD;
        }
        map.put(n, val);
        return val;
    }
}
