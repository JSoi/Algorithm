package com.soi.programmers;

import com.soi.tool.Assertions;

import java.util.Arrays;
import java.util.stream.IntStream;

public class L169198 {
    public static void main(String[] args) throws Exception {
        int[] solution = new L169198().solution(10, 10, 3, 7, new int[][]{{7, 7}, {2, 7}, {7, 3}});
        System.out.println(Arrays.toString(solution));
        Assertions.check(solution, new int[]{52, 37, 116});

    }

    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        IntStream.range(0, balls.length).forEach(
                i -> answer[i] = between(startX, startY, balls[i][0], balls[i][1], m, n)
        );
        return answer;
    }

    private int between(int x1, int y1, int x2, int y2, int minX, int minY) {
        int yAnswer, xAnswer;
        // x축에 평행
        xAnswer = (int) Math.pow(Math.abs(x1 - x2), 2);
        // 윗쪽
        int xTemp = getxTemp(x1, y1, x2, y2, minY);
        xAnswer += xTemp;
        // 아래쪽
        yAnswer = (int) Math.pow(Math.abs(y1 - y2), 2);
        // y축 평행
        int yTemp = getyTemp(x1, y1, x2, y2, minX);
        System.out.println(yTemp + "]]");
        yAnswer += yTemp;
        System.out.println(" --- --- " + xAnswer + " " + yAnswer);
        return Math.min(xAnswer, yAnswer);
    }

    private static int getxTemp(int x1, int y1, int x2, int y2, int minY) {
        int xTemp = Integer.MAX_VALUE;
        if (x1 == x2) { // 가로막힐 경우
            if (y1 < y2) {
                xTemp = (int) Math.pow(y1 + y2, 2);

            } else {
                xTemp = (int) Math.pow(2 * minY - (y1 + y2), 2);
            }
            return xTemp;
        }
        return Math.min(xTemp, (int) Math.pow(Math.min(y1 + y2, 2 * minY - (y1 + y2)), 2));
    }

    private static int getyTemp(int x1, int y1, int x2, int y2, int minX) {
        int yTemp = Integer.MAX_VALUE;
        if (y1 == y2) { // 가로막힐 경우
            if (x1 < x2) {
                yTemp = (int) Math.pow(x1 + x2, 2);
            } else {
                yTemp = (int) Math.pow(2 * minX - (x1 + x2), 2);
            }
            return yTemp;
        }
        return Math.min(yTemp, (int) Math.pow(Math.min(x1 + x2, 2 * minX - (x1 + x2)), 2));
    }
}
