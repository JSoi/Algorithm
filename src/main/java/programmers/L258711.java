package programmers;

import java.util.*;
import java.util.stream.IntStream;

public class L258711 {

    public static void main(String[] args) {
        int[] solution = new L258711().solution(new int[][]{{2, 3}, {4, 3}, {1, 1}, {2, 1}});
        System.out.println("Arrays.toString(solution) = " + Arrays.toString(solution));
    }

    static int[] visit;
    static int[] parent;
    static List<Integer>[] nodes;
    static boolean[][] conn;
    static int[] answer;

    public int[] solution(int[][] edges) {
        answer = new int[4]; // start, circle, stick, 8
        int length = Arrays.stream(edges).flatMapToInt(Arrays::stream).max().orElse(1);
        visit = new int[length + 1];
        parent = new int[length + 1];
        Arrays.fill(parent, -1);
        nodes = new List[length + 1];
        conn = new boolean[length + 1][length + 1];
        for (int i = 1; i <= length; i++) {
            nodes[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            nodes[e[0]].add(e[1]);
            parent[e[1]] = e[0];
            conn[e[0]][e[1]] = true;
        }

        int root = IntStream.rangeClosed(1, length)
                .filter(n -> parent[n] == -1).findFirst().orElse(0);
        answer[0] = root;
        visit[root] = 1;
        int totalGraph = 0;
        for (int child : nodes[root]) {
            totalGraph++;
            search(child);
        }
        System.out.println(Arrays.toString(visit));
        return answer;
    }

    static void search(int start) {
        Stack<Integer> dfs = new Stack<>();
        dfs.push(start);
        visit[start]++;
        while (!dfs.isEmpty()) {
            int latest = dfs.pop();
            for (int i : nodes[latest]) {
                if (visit[i] == 0) {
                    dfs.push(i);
                }
                visit[i]++;
            }
        }
    }

}
