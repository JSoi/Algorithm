package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * <a href = "https://www.acmicpc.net/problem/4386">별자리 만들기</a>
 */
public class N4386 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        double[][] pos = new double[N][2];
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            pos[i][0] = Double.parseDouble(line[0]);
            pos[i][1] = Double.parseDouble(line[1]);
        }
        boolean[] visit = new boolean[N];
        PriorityQueue<Node> nodes = new PriorityQueue<>();
        nodes.offer(new Node(0, 0, 0));
        double answer = 0;
        while (!nodes.isEmpty() && !allVisited(visit)) {
            Node poll = nodes.poll();
            int latest = poll.to;
            if (visit[latest]) {
                continue;
            }
            visit[latest] = true;
            answer += poll.distance;
            for (int j = 0; j < N; j++) {
                if (visit[j]) continue;
                nodes.offer(new Node(latest, j, distance(pos[latest][0], pos[latest][1], pos[j][0], pos[j][1])));
            }
        }
        System.out.println(answer);
    }

    private static boolean allVisited(boolean[] visit) {
        for (boolean v : visit) {
            if (!v) {
                return false;
            }
        }
        return true;
    }

    private static class Node implements Comparable<Node> {
        private int from;
        private int to;
        private double distance;

        public Node(int from, int to, double distance) {
            this.from = from;
            this.to = to;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node node) {
            return Double.compare(this.distance, node.distance);
        }
    }

    private static double distance(Double r1, Double c1, Double r2, Double c2) {
        return Math.sqrt(Math.pow((r1 - r2), 2) + Math.pow((c1 - c2), 2));
    }
}
