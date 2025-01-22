package baekjoon;

import java.io.*;

public class N12180 {
    public static final String CASE_WRITER = "Case #%d: %d";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = Integer.parseInt(br.readLine());
        for (int i = 1; i <= count; i++) {
            try {
                String[] input = br.readLine().split(" ");
                int r = Integer.parseInt(input[0]);
                int c = Integer.parseInt(input[1]);
                bw.append(String.format(CASE_WRITER, i, backtracking(0, 0, r, c, 1, new boolean[r * c])))
                        .append("\n");
            } catch (Exception e) {
                break;
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }

    // 상, 우, 하, 좌
    static final int[][] DIR = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    static int backtracking(int r, int c, int totalR, int totalC, int dir, boolean[] visit) {
        if (r < 0 || r >= totalR || c < 0 || c >= totalC || visit[r * totalC + c]) {
            return 0;
        }
        visit[r * totalC + c] = true;
        int value = 0;
        int nextR = r + DIR[dir][0];
        int nextC = c + DIR[dir][1];
        value += backtracking(nextR, nextC, totalR, totalC, dir, visit);

        int newDir = (dir + 1) % 4;
        nextR = r + DIR[newDir][0];
        nextC = c + DIR[newDir][1];
        value += backtracking(nextR, nextC, totalR, totalC, newDir, visit);
        visit[r * totalC + c] = false;
        return Math.max(value, 1);
    }
}
