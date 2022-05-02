package leetcode;

public class L733 {
    public final int[] dx = {0, 0, -1, 1};
    public final int[] dy = {1, -1, 0, 0};
    public boolean[][] visit;
    public int[][] map;
    public int color, newC;

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        this.visit = new boolean[image.length][image[0].length];
        this.map = image;
        this.color = map[sr][sc];
        this.newC = newColor;
        map[sr][sc] = newC;
        go(sr, sc);
        return map;
    }

    public void go(int s, int g) {
        for (int i = 0; i < 4; i++) {
            int ns = s + dx[i];
            int ng = g + dy[i];
            if (isRange(ns, ng) && !visit[ns][ng] && map[ns][ng] == color) {
                map[ns][ng] = newC;
                visit[ns][ng] = true;
                go(ns, ng);

            }
        }
    }

    public boolean isRange(int s, int g) {
        if (s < 0 || s >= map.length || g < 0 || g >= map[0].length) {
            return false;
        }
        return true;
    }
}
