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
        for (int i = 0; i < castleCount; i++) {
            dist[i] = minDist(i);
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

    private static int minDist(int start) {
        LinkedList<Integer> queue = new LinkedList<>();
        boolean[] visit = new boolean[castleCount + 1];
        queue.offer(start);
        visit[start] = true;
        int d = 0;
        while (!queue.isEmpty()) {
            int count = queue.size();
            while (count-- > 0) {
                int current = queue.poll();
                if (current == castleCount) {
                    return d;
                }
                for (int neighbor : connMap.get(current)) {
                    if (visit[neighbor]) {
                        continue;
                    }
                    visit[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
            d++;
        }
        return MAX;
    }
}
