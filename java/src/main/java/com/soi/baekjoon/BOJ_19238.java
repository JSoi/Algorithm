package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_19238 {
    private static final int[][] move = new int[][]{{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    private static int n;
    private static boolean[][] map;
    private static Map<Integer, Integer> deptDestMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        map = new boolean[n][n];
        int m = Integer.parseInt(st.nextToken());
        int fuel = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                map[i][j] = st.nextToken().equals("1");
            }
        }
        st = new StringTokenizer(br.readLine(), " ");
        int taxiR = Integer.parseInt(st.nextToken()) - 1;
        int taxiC = Integer.parseInt(st.nextToken()) - 1;

        deptDestMap = new HashMap<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int deptR = Integer.parseInt(st.nextToken()) - 1;
            int deptC = Integer.parseInt(st.nextToken()) - 1;
            int destR = Integer.parseInt(st.nextToken()) - 1;
            int destC = Integer.parseInt(st.nextToken()) - 1;
            deptDestMap.put(deptR * n + deptC, destR * n + destC);
        }
        TaxiStatus taxiStatus = new TaxiStatus(taxiR, taxiC, fuel);
        while (true) {
            // find customer
            taxiStatus = findCustomer(taxiStatus);
            if (taxiStatus == null) {
                System.out.println(-1);
                return;
            }
            // move to destination
            int customerPos = taxiStatus.row * n + taxiStatus.col;
            int destIdx = deptDestMap.get(customerPos);


            int startFuel = taxiStatus.fuel;
            taxiStatus = toDestination(taxiStatus, destIdx / n, destIdx % n);
            if (taxiStatus == null) {
                System.out.println(-1);
                return;
            }
            int usedFuel = startFuel - taxiStatus.fuel;
            taxiStatus.addFuel(usedFuel * 2);
            deptDestMap.remove(customerPos);
            if (deptDestMap.isEmpty()) {
                System.out.println(taxiStatus.fuel);
                return;
            }
        }
    }

    // used fuel * position
    private static TaxiStatus findCustomer(TaxiStatus taxiStatus) {
        int taxiR = taxiStatus.row;
        int taxiC = taxiStatus.col;
        int fuel = taxiStatus.fuel;
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> (
                a[2] == b[2] ? (a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]) : b[2]-a[2]));
        boolean[][] visited = new boolean[n][n];
        visited[taxiR][taxiC] = true;
        queue.offer(new int[]{taxiR, taxiC, fuel});
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int posIdx = curr[0] * n + curr[1];
            // find customer
            if (deptDestMap.containsKey(posIdx)) {
                return new TaxiStatus(curr[0], curr[1], curr[2]);
            }
            if (curr[2] == 0) { // zero fuel
                continue;
            }
            for (int[] mm : move) {
                int nR = curr[0] + mm[0];
                int nC = curr[1] + mm[1];
                if (nR < 0 || nR >= n || nC < 0 || nC >= n || visited[nR][nC] || map[nR][nC]) {
                    continue;
                }
                visited[nR][nC] = true;
                queue.offer(new int[]{nR, nC, curr[2] - 1});
            }
        }
        return null;
    }

    private static TaxiStatus toDestination(TaxiStatus status, int destR, int destC) {
        int taxiR = status.row;
        int taxiC = status.col;
        int fuel = status.fuel;
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][n];
        visited[taxiR][taxiC] = true;
        queue.offer(new int[]{taxiR, taxiC, fuel});
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            if (curr[0] == destR && curr[1] == destC) { // reached destination
                return new TaxiStatus(curr[0], curr[1], curr[2]);
            }
            if (curr[2] == 0) { // zero fuel
                continue;
            }
            for (int[] mm : move) {
                int nR = curr[0] + mm[0];
                int nC = curr[1] + mm[1];
                if (nR < 0 || nR >= n || nC < 0 || nC >= n || visited[nR][nC] || map[nR][nC]) {
                    continue;
                }
                visited[nR][nC] = true;
                queue.offer(new int[]{nR, nC, curr[2] - 1});
            }
        }
        return null;
    }

    private static class TaxiStatus {
        private int row;
        private int col;
        private int fuel;

        public TaxiStatus(int row, int col, int fuel) {
            this.row = row;
            this.col = col;
            this.fuel = fuel;
        }

        public void addFuel(int fuel) {
            this.fuel += fuel;
        }
    }
}
