package com.soi.programmers;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/86491">최소직사각형</a>
 */
public class L86491 {
    public int solution(int[][] sizes) {
        int garo = 0;
        int sero = 0;
        for(int[] purse : sizes){
            int pGaro = Math.max(purse[0], purse[1]);
            int pSero = Math.min(purse[0], purse[1]);
            garo = Math.max(garo, pGaro);
            sero = Math.max(sero, pSero);
        }
        return garo*sero;
    }
}
