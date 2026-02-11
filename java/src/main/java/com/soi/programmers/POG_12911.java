package com.soi.programmers;

public class POG_12911 {

    public static void main(String[] args) {

        solution(78);
    }

    public static int solution(int n) {
        int answer = 0;
        int compare = tentoTwoCount(n);
        while (true) {
            if (tentoTwoCount(++n) == compare) {
                answer = n;
                break;
            }
        }
        return answer;
    }

    public static int tentoTwoCount(int input) {
        int one = 0;
        while (input > 0) {
            if (input % 2 == 1)
                one++;
            input /= 2;
        }
        return one;
    }
}
