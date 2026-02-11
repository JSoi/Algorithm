package com.soi.programmers;

public class POG_43105 {

    public static void main(String[] args) {

        Solution43105 sol = new Solution43105();
        System.out
                .println(sol.solution(new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}}));
    }

}

class Solution43105 {
    int answer;

    public int solution(int[][] triangle) {
        answer = 0;
        fromLeaf(triangle);
        return answer;
    }

    public void giveMax(int row, int col, int val, int[][] triangle) {
        if (row >= triangle.length) {
            answer = Math.max(answer, val);
            return;
        }
        if (triangle[row].length <= col)
            return;
        giveMax(row + 1, col, val + triangle[row][col], triangle);
        giveMax(row + 1, col + 1, val + triangle[row][col], triangle);
    }

    public void fromLeaf(int[][] triangle) {
        if (triangle.length == 1) {
            answer = triangle[0][0];
            return;
        }
        // if(triangle.length==2) { answer = triangle[0][0]+; return;}
        for (int i = triangle.length - 1; i > 1; i--) {
            for (int j = 0; j < triangle[i].length - 1; j++) {
                triangle[i - 1][j] += Math.max(triangle[i][j], triangle[i][j + 1]);
            }
        }
        answer = triangle[0][0] + Math.max(triangle[1][0], triangle[1][1]);
    }
}