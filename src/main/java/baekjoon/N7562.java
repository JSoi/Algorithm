package baekjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href = "https://www.acmicpc.net/problem/7562">나이트의 이동</a>
 */
public class N7562 {
    static int testCase;
    static int n;
    static boolean[][] visit;
    static int startR, startC, targetR, targetC, answer;
    static final int[][] movements = new int[][]{{2, 1}, {2, -1}, {-2, 1}, {-2, -1}, {1, 2}, {1, -2}, {-1, 2}, {-1, -2}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        testCase = Integer.parseInt(br.readLine());

        for (int t = 0; t < testCase; t++) {
            n = Integer.parseInt(br.readLine());
            visit = new boolean[n][n];
            String[] start = br.readLine().split(" ");
            startR = Integer.parseInt(start[0]);
            startC = Integer.parseInt(start[1]);
            String[] target = br.readLine().split(" ");
            targetR = Integer.parseInt(target[0]);
            targetC = Integer.parseInt(target[1]);
            bw.append(String.valueOf(moveKnight())).append("\n");
        }
        bw.flush();
        br.close();
        bw.close();

    }

    private static int moveKnight() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startR, startC, 0});
        visit[startR][startC] = true;

        while (!queue.isEmpty()) {
            int[] latest = queue.poll();
            if (latest[0] == targetR && latest[1] == targetC) {
                return latest[2];
            }
            for (int[] m : movements) {
                int nR = latest[0] + m[0];
                int nC = latest[1] + m[1];
                if (!isInRange(nR, nC) || visit[nR][nC]) {
                    continue;
                }
                visit[nR][nC] = true;
                queue.offer(new int[]{nR, nC, latest[2] + 1});
            }
        }
        return 0;
    }

    static boolean isInRange(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < n;
    }

}