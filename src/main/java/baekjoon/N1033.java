package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * <a href ="https://www.acmicpc.net/problem/1033">칵테일</a>
 */
public class N1033 {
    private static List<Node>[] graph;
    private static int n;
    private static long[] weight;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        init();
        for (int i = 0; i < n; i++) {
            dfs(i);
        }
        long gcd = Arrays.stream(weight, 0, n).reduce((i1, i2) -> gcd(i1, i2)).orElse(1);
        for (int i = 0; i < n; i++) {
            weight[i] /= gcd;
        }
        System.out.println(
                IntStream.range(0, n).mapToObj(i -> String.valueOf(weight[i])).
                        collect(Collectors.joining(" ")));
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new List[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        weight = new long[n];
        long lcm = 1;
        for (int i = 0; i < n - 1; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int p = Integer.parseInt(input[2]);
            int q = Integer.parseInt(input[3]);

            long gcd = gcd(p, q);
            p /= gcd;
            q /= gcd;
            lcm *= ((p * q) / gcd(p, q));
            graph[a].add(new Node(b, p, q));
            graph[b].add(new Node(a, q, p));
        }
        weight[0] = lcm;
    }

    private static long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    private static void dfs(int node) {
        visited[node] = true;
        for (Node neighbor : graph[node]) {
            if (!visited[neighbor.to]) {
                weight[neighbor.to] = weight[node] * neighbor.toRatio / neighbor.fromRatio;
                dfs(neighbor.to);
            }
        }
    }

    private static class Node {
        int to;
        int fromRatio;
        int toRatio;

        public Node(int to, int fromRatio, int toRatio) {
            this.to = to;
            this.fromRatio = fromRatio;
            this.toRatio = toRatio;
        }
    }
}
