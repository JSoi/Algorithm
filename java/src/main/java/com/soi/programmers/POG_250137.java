package com.soi.programmers;


public class POG_250137 {
    public static void main(String[] args) {
        int[] bandage = {5, 1, 5};
        int health = 30;
        int[][] attacks = {{2, 10}, {9, 15}, {10, 5}, {11, 5}};
        int answer = new POG_250137().solution(bandage, health, attacks);
        System.out.println(answer);
    }

    public int solution(int[] bandage, int healthMax, int[][] attacks) {
        int health = healthMax;
        int continuedCount = 0;
        int attackIndex = 0;
        for (int tick = 0; tick <= attacks[attacks.length - 1][0]; tick++) {
            if (tick == attacks[attackIndex][0]) {
                health -= attacks[attackIndex][1];
                if (health <= 0) {
                    return -1;
                }
                attackIndex++;
                continuedCount = 0;
                continue;
            }
            continuedCount++;
            if (continuedCount == bandage[0]) { // 회복 가능
                health = Math.min(bandage[1] + bandage[2] + health, healthMax);
                continuedCount = 0;
            } else {
                health = Math.min(bandage[1] + health, healthMax);
            }
        }

        return health;
    }
}
