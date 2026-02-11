package com.soi.programmers;

import java.util.Scanner;

public class POG_12931 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.close();
        System.out.println(solution(n));
    }

    public static int solution(int n) {
        int answer = 0;
        int temp = n;
        while (temp > 0) {
            answer += temp % 10;
            temp /= 10;
        }
        return answer;
    }
}
