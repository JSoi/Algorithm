package com.soi.programmers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.stream.IntStream;

public class POG_258711 {
    private static int n;
    private static Set<Integer>[] nodes;
    private static int[] in, out;
    private static int[] answer;

    public static void main(String[] args) {
        int[] solution = solution(new int[][]{{2, 3}, {4, 3}, {1, 1}, {2, 1}});
        System.out.println("Arrays.toString(solution) = " + Arrays.toString(solution));
    }

    public static int[] solution(int[][] edges) {
        answer = new int[4];
        n = Arrays.stream(edges).flatMapToInt(Arrays::stream).max().orElse(1);

        nodes = new Set[n + 1];
        in = new int[n + 1];
        out = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            nodes[i] = new HashSet<>();
        }
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            nodes[u].add(v);
            out[u]++;
            in[v]++;
        }

        int root = IntStream.rangeClosed(1, n)
                .filter(n -> in[n] == 0 && out[n] >= 2).findFirst().orElse(0);
        answer[0] = root;
        for (int child : nodes[root]) {
            answer[count(child)]++;
        }
        return answer;
    }


    static int count(int start) {
        Stack<Integer> stack = new Stack<>();
        HashSet<Integer> visited = new HashSet<>();
        visited.add(start);
        stack.push(start);
        while (!stack.isEmpty()) {
            int curr = stack.pop();
            int type = getType(curr);
            if (type > 0) {
                return type;
            }
            for (int next : nodes[curr]) {
                if (visited.contains(next)) {
                    continue;
                }
                visited.add(next);
                stack.push(next);
            }
        }
        return 1;
    }

    static int getType(int node) {
        // start, doughnut, stick, 8
        if (out[node] == 0) { // stick
            return 2;
        }
        if (out[node] > 1) { // 8
            return 3;
        }
        return -1;
    }
}
