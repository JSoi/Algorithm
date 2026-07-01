package com.soi.leetcode;

/**
 * <a href = "https://leetcode.com/problems/find-the-winner-of-an-array-game/">Find the Winner of an Array Game</a>
 */
public class LC_find_the_winner_of_an_array_game {
    static class Solution {
        public int getWinner(int[] arr, int k) {
            int winner = arr[0];
            int winCount = 0;
            for (int i = 1; i < arr.length; i++) {
                int curr = arr[i];
                if (curr > winner) {
                    winCount = 1;
                    winner = curr;
                } else {
                    winCount++;
                }
                if (winCount >= k) return winner;
            }
            return winner;
        }
    }
}
