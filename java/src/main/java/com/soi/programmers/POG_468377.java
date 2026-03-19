package com.soi.programmers;

public class POG_468377 {
    public static void main(String[] args) {
        int sol = solution(
                new int[][]{
                        {49250, 42271, 40724, 36310, 32560, 30670, 24100, 10378},
                        {58510, 56101, 54078, 32864, 31443, 19451, 18098, 7187},
                        {68812, 66112, 65024, 60529, 53992, 39865, 31325, 17700},
                        {13768, 12866, 11379, 10425, 6853, 6176, 5655, 2556},
                        {51748, 48647, 41478, 39756, 25302, 18081, 16504, 811},
                        {52690, 34113, 32370, 29555, 19343, 11763, 7566, 5962},
                        {9306, 9190, 8196, 7573, 6275, 4723, 1316, 212},
                        {40713, 40158, 31449, 22349, 20956, 20377, 19489, 14450}
                },
                new int[][]{
                        {0, 2, 4, 6, 2},
                        {0, 6, 3, 3, 4},
                        {0, 6, 4, 5, 5},
                        {0, 7, 5, 8, 7},
                        {0, 7, 7, 7, 7},
                        {0, 7, 7, 7, 8},
                        {0, 8, 8, 8, 8}
                });
        System.out.println(sol);
    }

    private static int IMP = Integer.MAX_VALUE;

    public static int solution(int[][] cost, int[][] hint) {
        int stage = cost.length;
        int maxHint = stage - 1;

        int[] hintCost = new int[stage];
        int[][] hintArr = new int[stage][maxHint + 1];

        for (int h = 0; h < hint.length; h++) {
            hintCost[h] = hint[h][0];
            for (int es = 1; es < hint[h].length; es++) {
                int effectedStage = hint[h][es] - 1;
                hintArr[h][effectedStage]++;
            }
        }

        int answer = IMP;
        for (int status = 0; status < 1 << stage; status++) {
            int[] stageHintCount = new int[stage];
            for (int stg = 0; stg < stage; stg++) {
                if ((status & (1 << stg)) == 0) {
                    continue;
                }
                for (int ii = 0; ii < stage; ii++) {
                    stageHintCount[ii] += hintArr[stg][ii];
                }
            }
            int totalCost = 0;
            for (int i = 0; i < stage; i++) {
                totalCost += cost[i][Math.min(stageHintCount[i], maxHint)];
                if ((status & (1 << i)) != 0) {
                    totalCost += hintCost[i];
                }
            }
            answer = Math.min(answer, totalCost);
        }
        return answer;
    }
}
