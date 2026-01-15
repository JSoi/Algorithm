package com.soi.baekjoon;

import java.io.*;
import java.util.*;

public class N9205 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());
        while (testCase-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[][] conn = new int[n + 2][2];
            for (int i = 0; i < n + 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                conn[i][0] = Integer.parseInt(st.nextToken());
                conn[i][1] = Integer.parseInt(st.nextToken());
            }
            TestCase tc = new TestCase(conn);
            bw.append(tc.isAbleToArrive() ? "happy" : "sad").append("\n");
        }
        bw.flush();
    }

    private static class TestCase {
        Position start;
        Position end;
        int v;
        Map<Position, List<Position>> connMap;
        Set<Position> visited;

        private TestCase(int[][] conn) {
            start = new Position(conn[0][0], conn[0][1]);
            end = new Position(conn[conn.length - 1][0], conn[conn.length - 1][1]);
            v = conn.length;
            connMap = new HashMap<>();
            for (int i = 0; i < v; i++) {
                connMap.put(new Position(conn[i][0], conn[i][1]), new ArrayList<>());
            }
            findConnection(conn);
            visited = new HashSet<>();
        }

        private void findConnection(int[][] conn) {
            for (int i = 0; i < v - 1; i++) {
                for (int j = i + 1; j < v; j++) {
                    int dist = Math.abs(conn[i][0] - conn[j][0]) + Math.abs(conn[i][1] - conn[j][1]);
                    if ((double) dist / 50 <= 20) {
                        Position from = new Position(conn[i][0], conn[i][1]);
                        Position to = new Position(conn[j][0], conn[j][1]);
                        connMap.get(from).add(to);
                        connMap.get(to).add(from);
                    }
                }
            }
        }

        public boolean isAbleToArrive() {
            Queue<Position> queue = new LinkedList<>();
            visited.add(start);
            queue.offer(start);
            while (!queue.isEmpty()) {
                Position current = queue.poll();
                if (current.equals(end)) {
                    return true;
                }
                for (Position next : connMap.get(current)) {
                    if (visited.contains(next)) {
                        continue;
                    }
                    queue.offer(next);
                    visited.add(next);
                }
            }
            return false;
        }
    }

    private static class Position {
        int row;
        int col;

        public Position(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Position position = (Position) o;
            return row == position.row && col == position.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }
    }
}
