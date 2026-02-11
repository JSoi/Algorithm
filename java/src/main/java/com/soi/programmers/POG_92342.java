package com.soi.programmers;

import java.util.Arrays;

public class POG_92342 {
    static int[] apeachShootBoard;
    static int totalShootCount;
    static int gapBetween;
    static int[] answer;

    public static void main(String[] args) {
//        int[] solution = new POG_92342().solution(5, new int[]{2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0});
        int[] solution = new POG_92342().solution(3, new int[]{0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1});
//        int[] solution = new POG_92342().solution(9, new int[]{0, 0, 1, 2, 0, 1, 1, 1, 1, 1, 1});
        System.out.println(Arrays.toString(solution));
    }

    private static void shoot(int index, int lionLeftShootCount, int[] temp, int lionScore, int apeachScore) {
        // 어피치보다 1점 높게 쏘거나 아예 쏘지 않는 것이 이득
        if (index >= apeachShootBoard.length) {
            if (gapBetween < lionScore - apeachScore) {
                gapBetween = lionScore - apeachScore;
                answer = temp.clone();
            } else if (gapBetween == lionScore - apeachScore && !isDescendingOrder(answer, temp)) {
                answer = temp.clone();
            }
            return;
        }
        int apeachShootCount = apeachShootBoard[index];
        if (index == apeachShootBoard.length - 1) {
            temp[index] = lionLeftShootCount;
            int apeachAdditionalScore = apeachShootCount >= lionLeftShootCount ? 10 - index : 0;
            int lionAdditionalScore = apeachAdditionalScore == 0 ? 10 - index : 0;
            shoot(index + 1, 0, temp, lionScore + lionAdditionalScore, apeachScore + apeachAdditionalScore);
            return;
        }
        if (lionLeftShootCount > apeachShootCount) { // available to shoot
            temp[index] = apeachShootCount + 1;
            shoot(index + 1, lionLeftShootCount - apeachShootCount - 1, temp, lionScore + (10 - index), apeachScore);
        }
        temp[index] = 0;
        shoot(index + 1, lionLeftShootCount, temp, lionScore, apeachScore + (apeachShootCount == 0 ? 0 : (10 - index)));
    }

    private static boolean isDescendingOrder(int[] existing, int[] newly) {
        for (int i = existing.length - 1; i >= 0; i--) {
            if (existing[i] == newly[i]) {
                continue;
            }
            return existing[i] > newly[i];
        }
        return true;
    }

    public int[] solution(int n, int[] info) {
        answer = new int[info.length];
        apeachShootBoard = info;
        totalShootCount = n;
        gapBetween = 0;
        shoot(0, n, new int[info.length], 0, 0);
        if (gapBetween == 0) {
            return new int[]{-1};
        }
        return answer;
    }
}
