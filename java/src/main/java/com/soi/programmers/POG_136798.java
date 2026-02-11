package com.soi.programmers;

/**
 * <a href = "https://school.programmers.co.kr/learn/courses/30/lessons/136798">기사단원의 무기</a>
 */
public class POG_136798 {
    public static void main(String[] args) {
        new POG_136798().solution(5, 3, 2);
        new POG_136798().solution(10, 3, 2);
    }

    public int solution(int number, int limit, int power) {
        int answer = 0;
        int[] measureArr = measureCount(number);
        for (int m : measureArr) {
            answer += m > limit ? power : m;
        }
        return answer;
    }

    private int[] measureCount(int input) {
        int[] measureArr = new int[input];
        for (int multiple = 1; multiple <= input; multiple++) {
            for (int index = 1; index * multiple <= input; index++) {
                measureArr[multiple * index - 1]++;
            }
        }
        return measureArr;
    }
}
