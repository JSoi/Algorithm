package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class N1354 {
    static Map<Long, Long> map;

    public static void main(String[] args) throws IOException {
        map = new HashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] input = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        System.out.println(getValue(input[0], input[1], input[2], input[3], input[4]));
    }

    static long getValue(long n, long p, long q, long x, long y) {
        if (n <= 0) {
            return 1;
        }
        if (map.containsKey(n)) {
            return map.get(n);
        }
        long firstKey = n / p - x;
        long secondKey = n / q - y;
        long firstValue = getValue(firstKey, p, q, x, y);
        long secondValue = getValue(secondKey, p, q, x, y);
        map.put(n, firstValue + secondValue);
        return firstValue + secondValue;
    }
}
