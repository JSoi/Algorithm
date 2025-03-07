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
    private static int answer = Integer.MAX_VALUE;
    private static final List<List<int[][]>> movements =
            List.of(
                    List.of(new int[][]{{0, 1}}, new int[][]{{0, -1}}, new int[][]{{-1, 0}}, new int[][]{{1, 0}}),
                    List.of(new int[][]{{0, 1}, {0, -1}}, new int[][]{{1, 0}, {-1, 0}}),
                    List.of(new int[][]{{0, 1}, {-1, 0}}, new int[][]{{0, -1}, {1, 0}}, new int[][]{{1, 0}, {0, -1}}, new int[][]{{-1, 0}, {0, 1}}),
                    List.of(new int[][]{{0, 1}, {-1, 0}, {1, 0}}, new int[][]{{0, -1}, {1, 0}, {0, 1}}, new int[][]{{1, 0}, {0, -1}, {-1, 0}}, new int[][]{{-1, 0}, {0, 1}, {0, -1}}),
                    List.of(new int[][][]{new int[][]{{0, 1}, {-1, 0}, {1, 0}, {0, -1}}})
            );

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
                int value = Integer.parseInt(tok.nextToken());
                map[(r * col) + c] = value;
                if (value < 6 && value > 0) {
                    cameraList.add(new int[]{r, c, value});
                }
            }
        }
        go(0);
        System.out.println(answer);
    }

    private static void travel(int curR, int curC, int rDir, int cDir) {
        while (curR >= 0 && curR < row && curC >= 0 && curC < col && map[curR * col + curC] != 6) {
            if (map[curR * col + curC] == 0) {
                map[curR * col + curC] = -1;
            }
            curR += rDir;
            curC += cDir;
        }
    }

    private static void go(int depth) {
        if (depth == cameraList.size()) {
            answer = Math.min((int) Arrays.stream(map).filter(m -> m == 0).count(), answer);
//            System.out.println(print());
            return;
        }
        int[] cameraInfo = cameraList.get(depth);
        int r = cameraInfo[0];
        int c = cameraInfo[1];
        int cameraType = cameraInfo[2];
        int[] original = Arrays.copyOf(map, map.length);
        for (int[][] m : movements.get(cameraType - 1)) {
            for (int[] innerM : m) {
                travel(r, c, innerM[0], innerM[1]);
                go(depth + 1);
            }
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
