package programmers;

import java.util.*;

public class L86971 {
    public static void main(String[] args) {
        int solution = new L86971().solution(9, new int[][]{{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}});
        System.out.println(solution);
    }

    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        boolean[][] conn = new boolean[n + 1][n + 1];
        Arrays.sort(wires, Comparator.comparingInt(w -> w[0]));
        for (int[] wire : wires) {
            conn[wire[0]][wire[1]] = conn[wire[1]][wire[0]] = true;
        }
        for (int[] wire : wires) {
            conn[wire[0]][wire[1]] = conn[wire[1]][wire[0]] = false;
            answer = Math.min(answer, diff(conn));
            conn[wire[0]][wire[1]] = conn[wire[1]][wire[0]] = true;
        }

        return answer;
    }

    public int diff(boolean[][] origin) {
        // 하나만 탐색시 완료
        int count = 0;
        boolean[][] conn = origin.clone();
        boolean[] visit = new boolean[origin.length];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        while (!queue.isEmpty()) {
            Integer target = queue.poll();
            visit[target] = true;
            count++;
            for (int i = 0; i < conn.length; i++) {
                if (!visit[i] && (conn[target][i] || conn[i][target])) {
                    queue.offer(i);
                }
            }
        }
        return Math.abs(2 * count - conn.length + 1);

    }


}
