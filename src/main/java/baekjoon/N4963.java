package baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class N4963 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true) {
            String[] input = br.readLine().split(" ");
            int row = Integer.parseInt(input[1]);
            int col = Integer.parseInt(input[0]);
            if (row == 0 && col == 0) {
                break;
            }
            int[][] map = new int[row][col];
            for (int i = 0; i < row; i++) {
                map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }
            int answer = new Island(row, col, map).getAnswer();
            bw.append(String.valueOf(answer)).append("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

class Node {
    int r;
    int c;

    public Node(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

class Island {
    final int[][] movement = new int[][]{{-1, -1}, {1, 1}, {-1, 1}, {1, -1}, {0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int row;
    int col;
    int[][] map;
    int answer;

    public Island(int row, int col, int[][] map) {
        this.row = row;
        this.col = col;
        this.answer = 0;
        this.map = map;
        travel();
    }

    public void travel() {
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (map[r][c] == 1) {
                    bfs(r, c);
                }
            }
        }
    }
    private void bfs(int r, int c) {
        answer++;
        Queue<Node> bfs = new LinkedList<>();
        bfs.offer(new Node(r, c));
        while (!bfs.isEmpty()) {
            Node latest = bfs.poll();
            for (int[] m : movement) {
                int nextR = latest.r + m[0];
                int nextC = latest.c + m[1];
                if (isInRange(nextR, nextC) && map[nextR][nextC] == 1) {
                    map[nextR][nextC] = 0;
                    bfs.offer(new Node(nextR, nextC));
                }
            }
        }
    }

    boolean isInRange(int r, int c) {
        return r >= 0 && r < row && c >= 0 && c < col;
    }

    int getAnswer(){
        return this.answer;
    }
}

