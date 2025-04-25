package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class N1774 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        N = Integer.parseInt(nm[0]);
        int M = Integer.parseInt(nm[1]);
        int[][] position = new int[N + 1][2];
        HashMap<Integer, Set<Integer>> conn = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            String[] line = br.readLine().split(" ");
            position[i][0] = Integer.parseInt(line[0]);
            position[i][1] = Integer.parseInt(line[1]);
            conn.put(i, new HashSet<>());
        }

        for (int i = 0; i < M; i++) { // 연결된 노드
            String[] line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            conn.get(a).add(b);
            conn.get(b).add(a);
        }

        boolean[] visit = new boolean[N + 1];
        PriorityQueue<Edge> edges = new PriorityQueue<>();

        edges.offer(new Edge(1, 0));
        double answer = 0;
        while (!edges.isEmpty()) {
            Edge latest = edges.poll();
            int to = latest.to;
            if (visit[to]) {
                continue;
            }
            visit[to] = true;
            answer += latest.distance;
            for (int i = 1; i <= N; i++) {
                if (visit[i]) {
                    continue;
                }
                double d = conn.get(to).contains(i) ? 0 : distance(position[to][0], position[to][1], position[i][0], position[i][1]);
                edges.offer(new Edge(i, d));
            }
        }
        System.out.printf("%.2f\n", answer);
    }

    private static double distance(int r1, int c1, int r2, int c2) {
        return Math.sqrt(Math.pow((r1 - r2), 2) + Math.pow((c1 - c2), 2));
    }

    private static class Edge implements Comparable<Edge> {
        private int to;
        private double distance;

        public Edge(int to, double distance) {
            this.to = to;
            this.distance = distance;
        }

        @Override
        public int compareTo(Edge edge) {
            return Double.compare(this.distance, edge.distance);
        }
    }
}
