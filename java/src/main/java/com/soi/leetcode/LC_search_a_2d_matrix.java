package com.soi.leetcode;

public class LC_search_a_2d_matrix {
    public static void main(String[] args) {
        LC_search_a_2d_matrix lc = new LC_search_a_2d_matrix();
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        int target = 13;
        boolean result = lc.searchMatrix(matrix, target);
        System.out.println(result);
    }

    private int[][] matrix;
    int row, col;

    public boolean searchMatrix(int[][] matrix, int target) {
        this.matrix = matrix;
        // row
        this.row = matrix.length;
        this.col = matrix[0].length;
        int targetRow = searchRow(target);

        // col
        int targetCol = searchCol(targetRow, target);
        return target == matrix[targetRow][targetCol];
    }

    int searchRow(int target) {
        int l = 0;
        int r = row - 1;
        int mid;
        while (l < r) {
            mid = (l + r + 1) / 2;
            if (matrix[mid][0] < target) {
                if (l == mid)
                    return l;
                l = mid;
            } else if (matrix[mid][0] > target) {
                r = mid - 1;
            } else {
                return mid;
            }
        }
        return l;
    }

    int searchCol(int targetRow, int target) {
        int l = 0;
        int r = col - 1;
        int mid;
        while (l < r) {
            mid = (l + r + 1) / 2;
            if (matrix[targetRow][mid] < target) {
                l = mid;
            } else if (matrix[targetRow][mid] > target) {
                r = mid - 1;
            } else {
                return mid;
            }
        }
        return l;
    }
}
