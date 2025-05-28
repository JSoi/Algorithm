package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class N2250 {
    static int[] vertical;
    static int offset;
    static int[] parent;
    private static Map<Integer, List<Integer>> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        vertical = new int[N + 1];
        parent = new int[2 * N + 4];
        map = new HashMap<>();
        Arrays.fill(parent, -1);
        HashSet<Integer> childs = new HashSet<>();
        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            int c = Integer.parseInt(s[2]);
            if (b != -1) {
                parent[2 * a] = b;
                childs.add(b);
            }
            if (c != -1) {
                parent[2 * a + 1] = c;
                childs.add(c);
            }
        }
        int root = IntStream.rangeClosed(1, N).filter(i -> !childs.contains(i)).findFirst().orElse(0);
        travel(root, 1);
        int maxDiff = Integer.MIN_VALUE;
        int bestKey = Integer.MAX_VALUE;
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            int key = entry.getKey();
            List<Integer> values = entry.getValue().stream()
                    .map(v -> vertical[v])
                    .sorted()
                    .collect(Collectors.toList());
            int diff = values.isEmpty() ? 0 : values.get(values.size() - 1) - values.get(0) + 1;
            if (diff > maxDiff || (diff == maxDiff && key < bestKey)) {
                maxDiff = diff;
                bestKey = key;
            }
        }
        System.out.println(bestKey + " " + maxDiff);
    }

    static void travel(int n, int depth) {
        if (parent[2 * n] == -1 && parent[2 * n + 1] == -1) { // leaf node
            vertical[n] = offset++;
            map.computeIfAbsent(depth, k -> new ArrayList<>()).add(n);
            return;
        }
        // 좌축 자식 탐색
        if (parent[2 * n] != -1) {
            travel(parent[2 * n], depth + 1);
        }
        vertical[n] = offset++;
        map.computeIfAbsent(depth, k -> new ArrayList<>()).add(n);
        if (parent[2 * n + 1] != -1) {
            travel(parent[2 * n + 1], depth + 1);
        }
    }

}
