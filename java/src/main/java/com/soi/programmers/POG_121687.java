package com.soi.programmers;

public class POG_121687 {
    final int[][] direction = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int[] solution(String command) {
        int[] answer = {0, 0};
        int index = 1;
        char[] cArray = command.toCharArray();
        for (int i = 0; i < cArray.length; i++) {
            char A = cArray[i];
            if (A == 'G') {
                answer[0] += direction[index][0];
                answer[1] += direction[index][1];
            } else if (A == 'B') {
                answer[0] -= direction[index][0];
                answer[1] -= direction[index][1];
            } else if (A == 'R') {
                index = (index + 1) % 4;
            } else {
                index = (index + 3) % 4;
            }
        }
        return answer;
    }
}
