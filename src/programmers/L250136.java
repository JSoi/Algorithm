package programmers;

public class L250136 {
    public static void main(String[] args) {
        int solution = new L250136().solution(new int[][]{{0, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 1, 1, 0, 0}, {1, 1, 0, 0, 0, 1, 1, 0}, {1, 1, 1, 0, 0, 0, 0, 0}, {1, 1, 1, 0, 0, 0, 1, 1}});
    }

    static boolean[][] visit;
    static final int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    static int fuelColumnSum;

    public int solution(int[][] land) {
        int maxCount = 0;
        for (int i = 0; i < land[0].length; i++) {
            fuelColumnSum = 0;
            visit = new boolean[land.length][land[0].length];
            for (int j = 0; j < land.length; j++) {
                if (land[j][i] == 1 && !visit[j][i]) {
                    fuelSum(j, i, land, visit);
                }
            }
            if (fuelColumnSum > maxCount) {
                maxCount = fuelColumnSum;
            }
        }
        return maxCount;
    }

    private static void fuelSum(int r, int c, int[][] land, boolean[][] visit) {
        visit[r][c] = true;
        fuelColumnSum++;
        for (int[] d : dir) {
            int nextR = r + d[0];
            int nextC = c + d[1];
            if (nextR < 0 || nextR >= land.length || nextC < 0 || nextC >= land[0].length ||
                    land[nextR][nextC] == 0 || visit[nextR][nextC]) {
                continue;
            }
            fuelSum(nextR, nextC, land, visit);
        }
    }
}
