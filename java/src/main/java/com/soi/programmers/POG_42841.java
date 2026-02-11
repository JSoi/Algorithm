package com.soi.programmers;

import java.util.ArrayList;

public class POG_42841 {


    static ArrayList<Integer> numList;
    static boolean[] visit;

    public static void main(String[] args) {

        System.out.println(solution(new int[][]{{123, 1, 1}, {356, 1, 0}, {327, 2, 0}, {489, 0, 1}}));
    }

    public static int solution(int[][] baseball) {
        int answer = 0;
        numList = new ArrayList<Integer>();
        visit = new boolean[10];

        makeNum("");
        for (int i = 0; i < numList.size(); i++) {
            boolean flag = true;
            for (int j = 0; j < baseball.length; j++) {
                if (!ballorStrikeJudge(baseball[j][0], numList.get(i), baseball[j][1], baseball[j][2])) {
                    flag = false;
                    continue;
                }
            }
            if (flag)
                answer++;

        }
        return answer;
    }

    public static void makeNum(String num) {
        if (num.length() == 3)
            numList.add(Integer.parseInt(num));
        else {
            for (int i = 1; i < 10; i++) {
                if (!visit[i]) {
                    visit[i] = true;
                    makeNum(num + i);
                    visit[i] = false;
                }

            }
        }
    }


    public static boolean ballorStrikeJudge(int original, int compare, int strike, int ball) {
        int strikeCompare = 0;
        int ballCompare = 0;
        boolean[] visit = new boolean[10];
        visit[Integer.parseInt((original + "").charAt(0) + "")] = true;
        visit[Integer.parseInt((original + "").charAt(1) + "")] = true;
        visit[Integer.parseInt((original + "").charAt(2) + "")] = true;
        while (original > 0) {
            if (original % 10 == compare % 10) {
                strikeCompare++;
            } else if (visit[compare % 10]) {
                ballCompare++;
            }
            original /= 10;
            compare /= 10;
        }
        return strike == strikeCompare && ball == ballCompare;
    }

}
