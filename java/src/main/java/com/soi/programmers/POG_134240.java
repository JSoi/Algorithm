package com.soi.programmers;


/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/134240">푸드 파이트 대회</a>
 */
public class POG_134240 {
    public static void main(String[] args) {
        int[] food = {1, 3, 4, 6};
        String solution = new POG_134240().solution(food);
        System.out.println(solution);
    }

    public String solution(int[] food) {
        StringBuilder buf = new StringBuilder();
        for (int i = 1; i < food.length; i++) {
            buf.append(String.valueOf(i).repeat(food[i] / 2));
        }
        return buf + "0" + buf.reverse();
    }
}
