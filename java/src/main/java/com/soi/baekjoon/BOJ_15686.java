package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_15686 {
    static List<int[]> chickenHouseList;
    static List<int[]> houseList;
    static List<List<int[]>> totalAnswerList;
    static int liveHouseCount;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tok = new StringTokenizer(br.readLine(), " ");
        int mapSize = Integer.parseInt(tok.nextToken());
        map = new int[mapSize][mapSize];
        liveHouseCount = Integer.parseInt(tok.nextToken());

        chickenHouseList = new ArrayList<>();
        houseList = new ArrayList<>();
        totalAnswerList = new ArrayList<>();

        for (int l = 0; l < mapSize; l++) {
            tok = new StringTokenizer(br.readLine(), " ");
            for (int c = 0; c < mapSize; c++) {
                int num = Integer.parseInt(tok.nextToken());
                map[l][c] = num;
                if (num == 1) {
                    houseList.add(new int[]{l, c});
                } else if (num == 2) {
                    chickenHouseList.add(new int[]{l, c});
                }
            }
        }
        select(new ArrayList<>(), 0, new boolean[chickenHouseList.size()]);
        int answer = Integer.MAX_VALUE;
        for (List<int[]> chickenHouses : totalAnswerList) {
            answer = Math.min(answer, minSum(chickenHouses));
        }
        System.out.println(answer);
    }

    static int minSum(List<int[]> chicken) {
        int sum = 0;
        for (int[] h : houseList) {
            int subSum = Integer.MAX_VALUE;
            for (int[] c : chicken) {
                subSum = Math.min(Math.abs(c[0] - h[0]) + Math.abs(c[1] - h[1]), subSum);
            }
            sum += subSum;
        }
        return sum;
    }

    static void select(List<int[]> answerList, int chickenHouseIndex, boolean[] chickenHouseVisit) {
        if (answerList.size() == liveHouseCount) {
            totalAnswerList.add(answerList);
            return;
        }
        for (int i = chickenHouseIndex; i < chickenHouseList.size(); i++) {
            if (!chickenHouseVisit[i]) {
                chickenHouseVisit[i] = true;
                ArrayList<int[]> sublist = new ArrayList<>(answerList);
                sublist.add(chickenHouseList.get(i));
                select(sublist, i + 1, chickenHouseVisit);
                chickenHouseVisit[i] = false;
            }
        }
    }
}
