package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class N1074 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int N = (int) Math.pow(2, Integer.parseInt(line[0]));
        int row = Integer.parseInt(line[1]);
        int col = Integer.parseInt(line[2]);
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, N});
        int temp = 0;
        while (!queue.isEmpty()) {
            int[] latest = queue.poll();
            int offset = latest[2] / 2;
            int r = latest[0];
            int c = latest[1];
            if (latest[2] == 1) {
                if (r == row && c == col) {
                    System.out.println(temp);
                    return;
                }
                temp++;
                continue;
            }
            queue.offer(new int[]{r, c, offset});
            queue.offer(new int[]{r, c + offset, offset});
            queue.offer(new int[]{r + offset, c, offset});
            queue.offer(new int[]{r + offset, c + offset, offset});
        }
        System.out.println(-1);
    }
}
