package com.soi.programmers;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/87946">피로도</a>
 */
public class L87946 {
    static int[][] dungeonsInfo; // 최대 9개의 던전
    static int answer = 0;

    public static int solution(int k, int[][] dungeons) {
        dungeonsInfo = dungeons;
        visit(k, new boolean[dungeons.length], 0);
        return answer;
    }

    public static void visit(int leftPower, boolean[] visit, int count) {
        answer = Math.max(answer, count);
        for (int i = 0; i < dungeonsInfo.length; i++) {
            if (visit[i] || dungeonsInfo[i][0] > leftPower) continue;
            visit[i] = true;
            visit(leftPower-dungeonsInfo[i][1], visit, count + 1);
            visit[i] = false;
        }
    }


    public static void main(String[] args) {
        System.out.println(new L87946().solution(80, new int[][]{{80, 20}, {50, 40}, {30, 10}}));
    }
}
