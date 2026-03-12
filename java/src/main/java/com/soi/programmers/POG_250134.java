package com.soi.programmers;

public class POG_250134 {
    public static void main(String[] args) {
//        int ans = solution(new int[][]{{1, 4}, {0, 0}, {2, 3}});
//        int ans = solution(new int[][]{{1, 0, 2}, {0, 0, 0}, {5, 0, 5}, {4, 0, 3}});
//        int ans = solution(new int[][]{{1,5}, {2,5}, {4,5}, {3,5}});
        int ans = solution(new int[][]{{4, 1, 2, 3}});
        System.out.println("answer = " + ans);
    }

    private static final int[][] movement = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static int solution(int[][] maze) {
        Weagon weagon = new Weagon(maze);
        return weagon.solve();
    }


    private static class Weagon {
        private int[][] points = new int[4][2];
        private int answer = Integer.MAX_VALUE;
        private int r, c;
        private final int[][] map;
        private boolean[][] redVisit, blueVisit;

        public Weagon(int[][] map) {
            this.map = map;
            r = map.length;
            c = map[0].length;
            redVisit = new boolean[r][c];
            blueVisit = new boolean[r][c];

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (map[i][j] == 0 || map[i][j] == 5) {
                        continue;
                    }
                    int idx = getPoint(map[i][j]);
                    points[idx][0] = i;
                    points[idx][1] = j;
                }
            }
        }

        public int solve() {
            redVisit[points[0][0]][points[0][1]] = blueVisit[points[1][0]][points[1][1]] = true;
            dfs(points[0][0], points[0][1], points[1][0], points[1][1], 0);
            return answer == Integer.MAX_VALUE ? 0 : answer;
        }

        // map value to point array idx
        private int getPoint(int value) {
            return switch (value) {
                case 1, 2, 3, 4 -> value - 1;
                default -> throw new IllegalArgumentException();
            };
        }

        public void dfs(int redR, int redC, int blueR, int blueC, int turnCount) {
            if (turnCount >= answer) {
                return;
            }
            // red, blue reach destination
            if (redR == points[2][0] && redC == points[2][1] && blueR == points[3][0] && blueC == points[3][1]) {
                answer = turnCount;
                return;
            }
            for (int[] rm : movement) {
                int nRR, nRC;
                boolean redIdentical = false;
                if (redR == points[2][0] && redC == points[2][1]) {
                    nRR = redR;
                    nRC = redC;
                    redIdentical = true;
                } else {
                    nRR = redR + rm[0];
                    nRC = redC + rm[1];
                }
                if (!inRange(nRR, nRC)
                        || (!redIdentical && redVisit[nRR][nRC])
                        || map[nRR][nRC] == 5)
                    continue;

                for (int[] bm : movement) {
                    int nBR, nBC;
                    boolean blueIdentical = false;
                    if (blueR == points[3][0] && blueC == points[3][1]) {
                        nBR = blueR;
                        nBC = blueC;
                        blueIdentical = true;
                    } else {
                        nBR = blueR + bm[0];
                        nBC = blueC + bm[1];
                    }
                    if (!inRange(nBR, nBC)
                            || (!blueIdentical && blueVisit[nBR][nBC])
                            || map[nBR][nBC] == 5
                            || (nRR == nBR && nRC == nBC)
                            || (nRR == blueR && nRC == blueC && nBR == redR && nBC == redC)
                    ) continue;
                    redVisit[nRR][nRC] = blueVisit[nBR][nBC] = true;
                    dfs(nRR, nRC, nBR, nBC, turnCount + 1);
                    redVisit[nRR][nRC] = blueVisit[nBR][nBC] = false;
                }
            }
        }

        private boolean inRange(int rr, int cc) {
            return rr >= 0 && rr < r && cc >= 0 && cc < c;
        }
    }

}
