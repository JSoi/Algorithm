package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N1595 {
    static Map<Integer, List<int[]>> map = new HashMap<>();
    static boolean[] visited;
    static int farthestNode;
    static int maxDistance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String s = br.readLine();
            if (s == null || s.isEmpty()) break;
            int[] input = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
            map.computeIfAbsent(input[0], k -> new ArrayList<>()).add(new int[]{input[1], input[2]});
            map.computeIfAbsent(input[1], k -> new ArrayList<>()).add(new int[]{input[0], input[2]});
        }

        visited = new boolean[10001];
        maxDistance = 0;
        dfs(1, 0);

        visited = new boolean[10001];
        maxDistance = 0;
        dfs(farthestNode, 0);

        System.out.println(maxDistance);
    }

    static void dfs(int current, int distance) {
        visited[current] = true;
        if (distance > maxDistance) {
            maxDistance = distance;
            farthestNode = current;
        }
        if (map.get(current) == null) return;
        for (int[] neighbor : map.get(current)) {
            int nextNode = neighbor[0];
            int edgeDistance = neighbor[1];
            if (!visited[nextNode]) {
                dfs(nextNode, distance + edgeDistance);
            }
        }
    }
}
