package com.soi.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class L388352 {
    public static void main(String[] args) {
        new L388352().solution(15, new int[][]{{2, 3, 9, 12, 13}, {1, 4, 6, 7, 9}, {1, 2, 8, 10, 12}, {6, 7, 11, 13, 15}, {1, 4, 10, 11, 14}},
                new int[]{2, 1, 3, 0, 1});
    }

    static List<int[]> combList;

    public int solution(int n, int[][] q, int[] ans) {
        combList = new ArrayList<>();
        comb(n, 0, 1, new int[5]);
        for (int[] c : combList) {
            System.out.println(Arrays.toString(c));
        }
        Iterator<int[]> it = combList.iterator();
        while (it.hasNext()) {
            int[] next = it.next();
            boolean allSame = true;
            for (int qIdx = 0; qIdx < q.length; qIdx++) {
                int[] qq = q[qIdx];
                if (sameCount(n, qq, next) != ans[qIdx]) {
                    allSame = false;
                    break;
                }
            }
            if (!allSame) {
                it.remove();
            }
        }
        return combList.size();
    }


    private void comb(int n, int r, int start, int[] curr) {
        if (r == 5) {
            combList.add(curr.clone());
            return;
        }
        for (int i = start; i <= n; i++) {
            curr[r] = i;
            comb(n, r + 1, i + 1, curr);
        }
    }

    private int sameCount(int totalNum, int[] a, int[] b) {
        boolean[] tf = new boolean[totalNum + 1];
        for (int aa : a) {
            tf[aa] = true;
        }
        int answer = 0;
        for (int bb : b) {
            answer += (tf[bb] ? 1 : 0);
        }
        return answer;
    }
}
