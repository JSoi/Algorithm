package programmers;

import java.util.Arrays;

public class L340198 {
    public static void main(String[] args) {
        int solution = new L340198().solution(new int[]{5, 3, 2}, new String[][]{{"A", "A", "-1", "B", "B", "B", "B", "-1"}, {"A", "A", "-1", "B", "B", "B", "-1", "-1"}, {"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1"}, {"D", "D", "-1", "-1", "-1", "-1", "-1", "-1"}, {"D", "D", "-1", "-1", "-1", "-1", "-1", "F"}, {"D", "D", "-1", "-1", "-1", "-1", "-1", "-1"}});
        System.out.println(solution);
    }

    static int[][] lengthMatrix;
    static String[][] map;

    public static int solution(int[] mats, String[][] park) {
        map = park;
        lengthMatrix = new int[park.length][park[0].length];
        int maxLen = 0;
        for (int r = 0; r < park.length; r++) {
            for (int c = 0; c < park[0].length; c++) {
                lengthMatrix[r][c] = park[r][c].equals("-1") ? 1 : 0;
                if (park[r][c].equals("-1")) {
                    map[r][c] = "-";
                    if (r - 1 < 0 || c - 1 < 0) {
                        continue;
                    }
                    lengthMatrix[r][c] +=
                            Math.min(Math.min(lengthMatrix[r - 1][c], lengthMatrix[r - 1][c - 1]), lengthMatrix[r][c - 1]);
                    maxLen = Math.max(maxLen, lengthMatrix[r][c]);
                }
            }
        }
        int finalMaxLen = maxLen;
        return Arrays.stream(mats).filter(m -> m <= finalMaxLen).max().orElse(-1);
    }

}
