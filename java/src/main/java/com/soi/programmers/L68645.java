package com.soi.programmers;

import java.util.Arrays;

public class L68645 {
    public static void main(String[] args) {
        int[] solution = new L68645().solution(1);
//        int[] solution = new L68645().solution(4);
        System.out.println(Arrays.toString(solution));
    }

    public int[] solution(int n) {
        final int lastIndex = n * (n + 1) / 2;
        int index = 1;
        int row = 0;
        int col = 0;
        int[][] matrix = new int[n][n];
        int length = matrix.length;
        for (int[] m : matrix) {
            Arrays.fill(m, -1);
        }
        while (index <= lastIndex) {
            //down
            while (isInBoundary(row, col, length) && matrix[row][col] == -1) {
                matrix[row][col] = index++;
                if (row + 1 >= length || matrix[row + 1][col] != -1) {
                    col += 1;
                    break;
                }
                row++;
            }

            //right
            while (isInBoundary(row, col, length) && matrix[row][col] == -1) {
                matrix[row][col] = index++;
                if (col + 1 >= length || matrix[row][col + 1] != -1) {
                    row -= 1;
                    col -= 1;
                    break;
                }
                col++;
            }
            //up
            while (isInBoundary(row, col, length) && matrix[row][col] == -1) {
                matrix[row][col] = index++;
                if (row < 1 || col < 1 || matrix[row - 1][col - 1] != -1) {
                    row += 1;
                    break;
                }
                row--;
                col--;
            }
//            System.out.println(String.format("end : %d : %d", row, col));
        }
        return Arrays.stream(matrix)
//                .peek(m -> System.out.println(Arrays.toString(m)))
                .flatMapToInt(Arrays::stream)
                .filter(i -> i >= 0)
                .toArray();
    }

    private boolean isInBoundary(int row, int column, int size) {
        return row >= 0 && row < size && column >= 0 && column < size;
    }
}
