package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N1430 {
    private static int MAX = Integer.MAX_VALUE;
    private static int castleCount;
    private static Map<Integer, Set<Integer>> connMap;
    private static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        castleCount = Integer.parseInt(input[0]);
        int range = Integer.parseInt(input[1]);
        int initialEnergy = Integer.parseInt(input[2]);
        int enemyRow = Integer.parseInt(input[3]);
        int enemyCol = Integer.parseInt(input[4]);
        int[][] conn = new int[castleCount + 1][2];
        for (int i = 0; i < castleCount; i++) {
            conn[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        conn[castleCount] = new int[]{enemyRow, enemyCol};
        connMap = new HashMap<>();
        for (int i = 0; i <= castleCount; i++) {
            connMap.put(i, new HashSet<>());
        }
        for (int i = 0; i <= castleCount; i++) {
            for (int j = i + 1; j <= castleCount; j++) {
                int a = conn[i][0] - conn[j][0];
                int b = conn[i][1] - conn[j][1];
                if (a * a + b * b <= range * range) {
                    connMap.get(i).add(j);
                    connMap.get(j).add(i);
                }
            }
        }
        dist = new int[castleCount + 1];
        Arrays.fill(dist, MAX);
        dist[castleCount] = 0;

        boolean[] visited = new boolean[castleCount + 1];
        visited[castleCount] = true;

        LinkedList<Integer> queue = new LinkedList<>();
        queue.offer(castleCount);

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int next : connMap.get(curr)) {
                if (!visited[next]) {
                    visited[next] = true;
                    dist[next] = dist[curr] + 1;
                    queue.offer(next);
                }
            }
        }
        double answer = 0;
        for (int i = 0; i < castleCount; i++) {
            if (dist[i] == MAX) {
                continue;
            }
            answer += initialEnergy / Math.pow(2, dist[i] - 1.0);
        }
        System.out.println(answer);
    }
}
