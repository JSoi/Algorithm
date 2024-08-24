package programmers;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/159993">미로 탈출</a>
 */
public class L159993 {
    static char[][] mapChar;
    static int[][] point = new int[4][];
    static int answer = -1;
    static boolean[][] visited;
    static final int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static int solution(String[] maps) {
        mapChar = new char[maps.length][];
        for (int i = 0; i < maps.length; i++) {
            mapChar[i] = maps[i].toCharArray();
            if (maps[i].contains("S")) {
                point[0] = new int[]{i, maps[i].indexOf("S")};
            }
            if (maps[i].contains("C")) {
                point[1] = new int[]{i, maps[i].indexOf("C")};
            }
            if (maps[i].contains("L")) {
                point[2] = new int[]{i, maps[i].indexOf("L")};
            }
            if (maps[i].contains("E")) {
                point[3] = new int[]{i, maps[i].indexOf("E")};
            }
        }
        int toLever = find(point[0][0], point[2][0], point[0][1], point[2][1]);
        if (toLever == -1) {
            return -1;
        }
        int leverToDestination = find(point[2][0], point[3][0], point[2][1], point[3][1]);
        if (leverToDestination == -1) {
            return -1;
        }
        return toLever + leverToDestination;

    }

    static int find(int fromR, int toR, int fromC, int toC) {
        boolean[][] visit = new boolean[mapChar.length][mapChar[0].length];
        Queue<Node> queue = new LinkedList<>();
        int answer = Integer.MAX_VALUE;
        queue.offer(new Node(fromR, fromC, 0));
        while (!queue.isEmpty()) {
            Node target = queue.poll();
            if (target.r == toR && target.c == toC) {
                answer = Math.min(target.distance, answer);
            }
            for (int[] dir : directions) {
                int nextR = target.r + dir[0];
                int nextC = target.c + dir[1];
                if (nextR < 0 || nextR >= mapChar.length || nextC < 0 || nextC >= mapChar[0].length || visit[nextR][nextC] || mapChar[nextR][nextC] == 'X') {
                    continue;
                }
                visit[nextR][nextC] = true;
                queue.offer(new Node(nextR, nextC, target.distance + 1));
            }
        }
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    static class Node {
        int r, c;
        int distance;

        public Node(int r, int c, int distance) {
            this.r = r;
            this.c = c;
            this.distance = distance;
        }
    }

    public static void travel(int r, int c, int endH, int endV, int walkCount) {
        if (r == endH && c == endV) {
            answer = answer == -1 ? walkCount : Math.min(answer, walkCount);
            return;
        }
        for (int[] dir : directions) {
            int nextR = r + dir[0];
            int nextC = c + dir[1];
            if (nextR < 0 || nextR >= mapChar.length || nextC < 0 || nextC >= mapChar[0].length || visited[nextR][nextC] || mapChar[nextR][nextC] == 'X') {
                continue;
            }
            visited[nextR][nextC] = true;
            travel(nextR, nextC, endH, endV, walkCount + 1);
            visited[nextR][nextC] = false;
        }
    }

    public static void main(String[] args) {
        String[] maps = {"SOOOL", "XXXXO", "OOOOO", "OXXXX", "OOOOE"};
//        String[] maps2 = {"LOOXS", "OOOOX", "OOOOO", "OOOOO", "EOOOO"};
//        String[] maps3 = {"LOEOS", "XXXXX", "XXXXX", "XXXXX", "XXXXX"};
        System.out.println(new L159993().solution(maps));
//        System.out.println(new L159993().solution(maps3));
    }
}
