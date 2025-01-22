package baekjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

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
                bw.append(String.format(CASE_WRITER, i, solution(r, c))).append("\n");
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

    static int solution(int r, int c) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(r - 1, 0, 0, 1L << ((r - 1) * c))); // 시작점
        int answer = 0;
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            boolean isGraceful = false;
            for (int m = 0; m <= 1; m++) {
                int nd = (current.d + m) % 4;
                int nr = current.r + DIR[nd][0];
                int nc = current.c + DIR[nd][1];
                int posMask = 1 << (c * nr + nc);
                if (nr >= 0 && nr < r && nc >= 0 && nc < c && (current.mask & posMask) == 0) {
                    isGraceful = true;
                    queue.offer(new Node(nr, nc, nd, current.mask | posMask));
                }
            }
            if (!isGraceful) {
                answer++;
            }
        }
        return answer;
    }


    static class Node {
        int r;
        int c;
        int d;
        long mask;

        Node(int r, int c, int d, long mask) {
            this.r = r;
            this.c = c;
            this.d = d;
            this.mask = mask;
        }
    }
}
