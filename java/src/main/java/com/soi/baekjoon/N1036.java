package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class N1036 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        String[] base36Arr = new String[count];
        for (int i = 0; i < count; i++) {
            base36Arr[i] = br.readLine();
        }
        int changeCount = Integer.parseInt(br.readLine());
        String answer = solve(base36Arr, changeCount);
        System.out.println(answer);
    }

    private static BigDecimal[] diffArr;

    private static String solve(String[] base36Arr, int k) {
        diffArr = new BigDecimal[36];
        Arrays.fill(diffArr, BigDecimal.ZERO);
        BigDecimal sum = BigDecimal.ZERO;
        for (String base36 : base36Arr) {
            BigDecimal decimalValue = fromBase36ToDecimal(base36);
            sum = sum.add(decimalValue);
            putDifference(base36);
        }
        List<BigDecimal> list = Arrays.stream(diffArr).sorted(Collections.reverseOrder()).collect(Collectors.toList());
        for (BigDecimal l : list) {
            if (k <= 0) {
                break;
            }
            if (l.signum() > 0) {
                sum = sum.add(l);
                k--;
            }
        }
        return fromDecimalToBase36(sum);
    }

    static void putDifference(String str) {
        for (int i = 0; i < str.length(); i++) {
            int target = toDecimal(str.charAt(i));
            BigDecimal valueWithPosition = BigDecimal.valueOf(35 - target).multiply(BigDecimal.valueOf(36).pow(str.length() - i - 1));
            diffArr[target] = diffArr[target].add(valueWithPosition);
        }
    }

    static BigDecimal fromBase36ToDecimal(String base36) {
        char[] bArr = base36.toCharArray();
        BigDecimal value = BigDecimal.ZERO;
        for (int i = 0; i < bArr.length; i++) {
            value = value.add(BigDecimal.valueOf(toDecimal(bArr[bArr.length - i - 1])).multiply(BigDecimal.valueOf(36).pow(i)));
        }
        return value;
    }

    static String fromDecimalToBase36(BigDecimal decimal) {
        String base36 = "";
        while (decimal.signum() > 0) {
            int remainder = (decimal.remainder(BigDecimal.valueOf(36))).intValue();
            char remainderToChar = to36Char(remainder);
            base36 = remainderToChar + base36;
            decimal = decimal.divide(BigDecimal.valueOf(36), 0, RoundingMode.DOWN);
        }
        return base36.isBlank() ? "0" : base36;
    }

    static char to36Char(int input) {
        if (input >= 0 && input <= 9) {
            return (char) (input + '0');
        } else if (input >= 10 && input < 36) {
            return (char) ('A' + (input - 10));
        } else {
            throw new IllegalArgumentException();
        }
    }

    static int toDecimal(char input) {
        if (input >= 'A' && input <= 'Z') {
            return (input - 'A') + 10;
        } else {
            return input - '0';
        }
    }
}
