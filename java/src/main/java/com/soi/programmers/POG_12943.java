package com.soi.programmers;

public class POG_12943 {
    static int count = 0;

    public static void main(String[] args) {
        System.out.println(solution(626331));
    }

    public static int solution(long num) {
        System.out.println(num + " / count : " + count);
        if (num == 1)
            return count;
        else if (count == 500)
            return -1;
        else if (num % 2 == 0) {
            count++;
            return solution(num / 2);
        } else {
            count++;
            return solution(num * 3 + 1);
        }
    }
}
