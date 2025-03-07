package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class N15683 {
    private static int[] map;
    private static List<int[]> cameraList;
    private static int row;
    private static int col;
    private static int answer;

    public static int[] dr = {-1, 1, 0, 0};
    public static int[] dc = {0, 0, -1, 1};

    public static int[][][] cctv = {{{0}},
            {{0}, {1}, {2}, {3}},
            {{2, 3}, {0, 1}},
            {{0, 3}, {1, 3}, {1, 2}, {0, 2}},
            {{0, 2, 3}, {0, 1, 3}, {1, 2, 3}, {0, 1, 2}},
            {{0, 1, 2, 3}}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        row = Integer.parseInt(input[0]);
        col = Integer.parseInt(input[1]);
        map = new int[row * col];
        cameraList = new ArrayList<>();
        for (int r = 0; r < row; r++) {
            StringTokenizer tok = new StringTokenizer(br.readLine(), " ");
            for (int c = 0; c < col; c++) {
                int type = Integer.parseInt(tok.nextToken());
                map[(r * col) + c] = type;
                if (type < 6 && type > 0) {
                    cameraList.add(new int[]{r, c, type});
                }
            }
        }
        answer = (int) Arrays.stream(map).filter(m -> m == 0).count();
        go(0);
        System.out.println(answer);
    }

    private static void travel(int curR, int curC, int rDir, int cDir) {
        curR += rDir;
        curC += cDir;
        while (curR >= 0 && curR < row && curC >= 0 && curC < col && map[curR * col + curC] != 6) {
            map[curR * col + curC] = -1;
            curR += rDir;
            curC += cDir;
        }
    }

    private static void go(int depth) {
        if (depth == cameraList.size()) {
            int count = (int) Arrays.stream(map).filter(m -> m == 0).count();
            answer = Math.min(count, answer);
            return;
        }
        int[] cameraInfo = cameraList.get(depth);
        int r = cameraInfo[0];
        int c = cameraInfo[1];
        int cameraType = cameraInfo[2];
        int[] original = Arrays.copyOf(map, map.length);
        for (int i = 0; i < cctv[cameraType].length; i++) {
            for (int j = 0; j < cctv[cameraType][i].length; j++) {
                int dir = cctv[cameraType][i][j];
                travel(r, c, dr[dir], dc[dir]);
            }
            go(depth + 1);
            System.arraycopy(original, 0, map, 0, map.length);
        }
    }

    private static String print() {
        StringBuffer buf = new StringBuffer();
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                buf.append(map[r * col + c]).append(" ");
            }
            buf.append("\n");
        }
        return buf.toString();
    }
}
