package com.soi.baekjoon;

import java.io.*;
import java.util.Map;

public class N1063 {
    static final Map<String, int[]> map =
            Map.of(
                    "R", new int[]{0, 1},
                    "L", new int[]{0, -1},
                    "B", new int[]{-1, 0},
                    "T", new int[]{1, 0},
                    "RT", new int[]{1, 1},
                    "LT", new int[]{1, -1},
                    "RB", new int[]{-1, 1},
                    "LB", new int[]{-1, -1}
            );

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        String king = input[0];
        String stone = input[1];
        int caseCount = Integer.parseInt(input[2]);
        for (int c = 0; c < caseCount; c++) {
            String command = br.readLine();
            int[] movement = map.get(command);
            char nextKingRow = (char) (king.charAt(1) + movement[0]);
            char nextKingCol = (char) (king.charAt(0) + movement[1]);
            if (nextKingRow == stone.charAt(1) && nextKingCol == stone.charAt(0)) {
                char nextStoneRow = (char) (stone.charAt(1) + movement[0]);
                char nextStoneCol = (char) (stone.charAt(0) + movement[1]);
                if (isInRange(nextKingRow - '0') && isInRange(nextKingCol - 'A' + 1)
                        && isInRange(nextStoneRow - '0') && isInRange(nextStoneCol - 'A' + 1)
                ) {
                    king = nextKingCol + "" + nextKingRow;
                    stone = nextStoneCol + "" + nextStoneRow;
                }
            } else {
                if (isInRange(nextKingRow - '0') && isInRange(nextKingCol - 'A' + 1)
                ) {
                    king = nextKingCol + "" + nextKingRow;
                }
            }
        }
        bw.append(king).append("\n").append(stone);
        bw.flush();

        br.close();
        bw.close();
    }

    private static boolean isInRange(int input) {
        return input > 0 && input < 9;
    }
}
