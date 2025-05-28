package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class N1394 {
    public static final int DIV = 900528;
    public static int cLen;
    public static Map<Integer, Long> powMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        powMap = new HashMap<>();
        String givenPasswordChar = br.readLine();
        String password = br.readLine();
        int n = password.length();
        cLen = givenPasswordChar.length();
        powMap.put(0, 1L);
        powMap.put(1, (long) cLen);
        long answer = 0;
        for (int i = 0; i < n - 1; i++) {
            answer = (answer + customPow(i + 1)) % DIV;
        }
        long attempt = 0;
        for (int i = 0; i < n; i++) {
            int k = givenPasswordChar.indexOf(password.charAt(i));
            attempt += (customPow(n - i - 1) * k) % DIV;
        }
        answer = (answer + attempt + 1) % DIV;
        System.out.println(answer);
    }

    private static long customPow(int pow) {
        if (powMap.get(pow) != null) {
            return powMap.get(pow);
        }
        long value = cLen * customPow(pow - 1) % DIV;
        powMap.put(pow, value);
        return value;
    }
}
