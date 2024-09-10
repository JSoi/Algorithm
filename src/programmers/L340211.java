package programmers;

import java.util.*;

public class L340211 {
    static final int[][] movement = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    static boolean[][] visit;
    static int targetRow, targetCol, distance;
    static List<Node> answerList;

    public static void main(String[] args) {
        int solution = new L340211().solution(new int[][]{{3, 2}, {6, 4}, {4, 7}, {1, 4}}, new int[][]{{4, 2}, {1, 3}, {2, 4}});
    }

    public static int solution(int[][] points, int[][] routes) {
        int maxRow = Arrays.stream(points).mapToInt(p -> p[0]).max().orElse(0) + 1;
        int maxCol = Arrays.stream(points).mapToInt(p -> p[1]).max().orElse(0) + 1;
        visit = new boolean[maxRow][maxCol];
        int routeIndex = 0;
        HashMap<Integer, ArrayList<Node>> map = new HashMap<>();
        for (int[] route : routes) {
            int fromPoint = route[0];
            int toPoint = route[1];
            Arrays.stream(visit).forEach(row -> Arrays.fill(row, false));

            int fromCol = points[fromPoint - 1][1] - 1;
            int fromRow = points[fromPoint - 1][0] - 1;

            init(points, toPoint, fromCol, fromRow);
            ArrayList<Node> routeList = new ArrayList<>();
            routeList.add(new Node(fromRow, fromCol, 0));
            explore(fromRow, fromCol, 0, routeList);
            map.put(routeIndex++, new ArrayList<>(answerList));
        }
        return findCollisionTime(map);
    }

    private static void init(int[][] points, int toPoint, int fromCol, int fromRow) {
        targetRow = points[toPoint - 1][0] - 1;
        targetCol = points[toPoint - 1][1] - 1;
        distance = Math.abs(targetCol - fromCol) + Math.abs(targetRow - fromRow) + 1;
        visit[fromRow][fromCol] = true;
    }

    private static int findCollisionTime(HashMap<Integer, ArrayList<Node>> map) {
        int size = map.values().stream().mapToInt(ArrayList::size).max().orElse(1);
        int collision = 0;
        for (int time = 0; time < size; time++) {
            HashMap<Point, Integer> points = new HashMap<>();
            for (ArrayList<Node> nodes : map.values()) {
                if (nodes.size() <= time) {
                    continue;
                }

                Point newPoint = new Point(nodes.get(time).row, nodes.get(time).col);
                points.put(newPoint, points.getOrDefault(newPoint, 0) + 1);
            }
            collision += (int) points.entrySet().stream().filter(e -> e.getValue() >= 2).count();
        }
        return collision;
    }

    private static void explore(int row, int col, int dist, List<Node> routeList) {
        if (row == targetRow && col == targetCol) {
            if (dist < distance) {
                distance = dist;
                answerList = routeList;
            }
            return;
        }

        for (int[] mv : movement) {
            int nextRow = row + mv[0];
            int nextCol = col + mv[1];
            if (nextCol < 0 || nextCol >= visit[0].length || nextRow < 0 || nextRow >= visit.length
                    || visit[nextRow][nextCol] || dist > distance) {
                continue;
            }
            LinkedList<Node> subList = new LinkedList<>(routeList);
            subList.add(new Node(nextRow, nextCol, dist + 1));
            visit[nextRow][nextCol] = true;
            explore(nextRow, nextCol, dist + 1, subList);
            visit[nextRow][nextCol] = false;
        }
    }

    private static class Point {
        int row;
        int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return row == point.row && col == point.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }
    }

    private static class Node {
        int row;
        int col;
        int dist;

        public Node(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }
}
