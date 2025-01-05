package baekjoon;

import java.util.*;
import java.util.stream.Collectors;

public class N1682 {
    static int[] target;
    static HashSet<String> visited;
    static final int[][] move = new int[][]{
            {7, 6, 5, 4, 3, 2, 1, 0},
            {3, 0, 1, 2, 5, 6, 7, 4},
            {0, 2, 5, 3, 4, 6, 1, 7},
            {4, 1, 2, 3, 0, 5, 6, 7}
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        target = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        visited = new HashSet<>();
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        Queue<Node> bfs = new LinkedList<>();
        String currentStr = getVisitStr(arr);
        String targetStr = getVisitStr(target);
        Node initNode = new Node(0, currentStr);
        bfs.offer(initNode);
        visited.add(currentStr);

        while (!bfs.isEmpty()) {
            Node latest = bfs.poll();
            if (latest.state.equals(targetStr)) {
                System.out.println(latest.count);
                return;
            }
            for (int[] m : move) {
                String nextState = "";
                for (int i = 0; i < 8; i++) {
                    nextState += latest.state.charAt(m[i]);
                }
                if (visited.contains(nextState)) {
                    continue;
                }
                visited.add(nextState);
                bfs.offer(new Node(latest.count + 1, nextState));
            }
        }
        System.out.println(-1);
    }

    static String getVisitStr(int[] nextState) {
        return Arrays.stream(nextState).mapToObj(String::valueOf).collect(Collectors.joining(""));
    }
    private static class Node {
        int count;
        String state;

        public Node(int count, String state) {
            this.count = count;
            this.state = state;
        }
    }
}
