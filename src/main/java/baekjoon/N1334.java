package baekjoon;

import java.math.BigInteger;
import java.util.Scanner;

public class N1334 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String target = scan.nextLine();
        BigInteger original;
        if (isAllNine(target)) {
            original = new BigInteger(target).add(BigInteger.ONE);
            target = original.toString();
        } else {
            original = new BigInteger(target);
        }
        int len = target.length();
        if (len == 1) {
            System.out.println(original.add(BigInteger.ONE));
            return;
        }
        BigInteger left = new BigInteger(target.substring(0, len / 2));
        BigInteger palindrome;
        if (len % 2 == 0) { // 짝수
            palindrome = new BigInteger(left.toString() + new StringBuffer(left.toString()).reverse());
            while (original.compareTo(palindrome) >= 0) {
                left = left.add(BigInteger.ONE);
                palindrome = new BigInteger(left.toString() + new StringBuffer(left.toString()).reverse());
            }
        } else {
            palindrome = new BigInteger(left.toString() + new StringBuffer(left.divide(BigInteger.TEN).toString()).reverse());
            while (original.compareTo(palindrome) >= 0) {
                left = left.add(BigInteger.ONE);
                palindrome = new BigInteger(left.toString() + new StringBuffer(left.divide(BigInteger.TEN).toString()).reverse());
            }
        }
        System.out.println(palindrome);
    }

    static boolean isAllNine(String target) {
        for (char c : target.toCharArray()) {
            if (c != '9') {
                return false;
            }
        }
        return true;
    }
}
