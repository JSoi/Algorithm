package baekjoon;

import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class N1629 {

    public static void main(String[] args) {
        String input = new Scanner(System.in).nextLine();
        StringTokenizer tok = new StringTokenizer(input, " ");
        long a = Long.parseLong(tok.nextToken());
        long b = Long.parseLong(tok.nextToken());
        long c = Long.parseLong(tok.nextToken());
//        long a = 2_147_483_647L;
//        long b = 2_147_483_647L;
//        long c = 2_147_483_647L;
        // (a * a) % c = (a%c * a%c) %c
        //
        long current = a;
        for (int i = 0; i < b; i++) {
            current *= a;
            System.out.println(current%c);

//        System.out.println(current);
        }
        System.out.println(current % c);
    }

    private static long val(long current, long mulVal, long div) {
        return (current % div * mulVal % div) % div;
    }
}
