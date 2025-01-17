package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class N1351 {
    private static Map<Long, Long> map;
    public static void main(String[] args) throws IOException {
        map = new HashMap<>();
        map.put(0L, 1L);
        String[] input = new BufferedReader(new InputStreamReader(System.in)).readLine().split(" ");
        long n = Long.parseLong(input[0]);
        int p = Integer.parseInt(input[1]);
        int q = Integer.parseInt(input[2]);
        long answer = getValue(n, p, q);
        System.out.println(answer);
    }
    public static long getValue(long n, int p, int q) {
        if (n == 0) {
            return 1;
        }
        long firstKey = n / p;
        long secondKey = n / q;
        map.putIfAbsent(firstKey, getValue(firstKey, p, q));
        map.putIfAbsent(secondKey, getValue(secondKey, p, q));
        return map.get(firstKey) + map.get(secondKey);
    }
}
