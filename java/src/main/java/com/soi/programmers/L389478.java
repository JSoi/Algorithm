package com.soi.programmers;

public class L389478 {
    public static void main(String[] args) {
        new L389478().solution(22, 6, 8);
    }

    public int solution(int n, int w, int num) {
        int[] count = new int[w];
        for (int i = 1; i <= n; i++) {
            int col = (i - 1) % w;
            int row = (i - 1) / w;
            count[row % 2 == 0 ? col : w - col - 1]++;
        }
        int col = (num - 1) % w;
        int row = (num - 1) / w;
        return  count[row % 2 == 0 ? col : w - col - 1] - row;
    }
}
