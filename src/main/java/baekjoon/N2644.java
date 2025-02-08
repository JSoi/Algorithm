package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N2644 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ppl = Integer.parseInt(br.readLine());
        int[] target = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int lineCount = Integer.parseInt(br.readLine());
        List<Integer>[] conn = new List[ppl + 1];
        for (int i = 1; i < conn.length; i++) {
            conn[i] = new ArrayList<>();
        }
        for (int i = 0; i < lineCount; i++) {
            int[] line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            conn[line[0]].add(line[1]);
            conn[line[1]].add(line[0]);
        }
        boolean[] visited = new boolean[ppl + 1];
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(target[0], 0));
        while (!queue.isEmpty()) {
            Node latest = queue.poll();
            visited[latest.index] = true;
            if (latest.index == target[1]) {
                System.out.println(latest.depth);
                return;
            }
            for (int adj : conn[latest.index]) {
                if (!visited[adj]) {
                    queue.offer(new Node(adj, latest.depth + 1));
                }
            }
        }
        System.out.println(-1);
    }

    private static class Node {
        int index;
        int depth;

        public Node(int index, int depth) {
            this.index = index;
            this.depth = depth;
        }
    }
}
