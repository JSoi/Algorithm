package com.soi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N1525 {

    static final int[][] pos = new int[][]
            {
                    {1, 3}, {-1, 1, 3}, {-1, 3},
                    {1, -3, 3}, {-1, 1, -3, 3}, {-1, -3, 3},
                    {1, -3}, {-1, 1, -3}, {-1, -3}
            };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            String line = br.readLine();
            sb.append(line.replace(" ", ""));
        }
        HashSet<Integer> visited = new HashSet<>();
        String s = sb.toString();
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{Integer.parseInt(s), 0});
        visited.add(Integer.parseInt(s));
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
//            System.out.println(String.format("%s  - %d", cur.str, cur.dist));
            if (cur[0] == 123456780) {
                System.out.println(cur[1]);
                return;
            }
            for (int candidates : move(cur[0])) {
                if (visited.contains(candidates)) continue;
                visited.add(candidates);
                queue.add(new int[]{candidates, cur[1] + 1});
            }
        }
        System.out.println(-1);
    }

    static List<Integer> move(int initial) {
        String initialStr = String.format("%09d", initial);
        int zeroIdx = initialStr.indexOf('0');
        ArrayList<Integer> next = new ArrayList<>();
        for (int move : pos[zeroIdx]) {
            int newZero = zeroIdx + move;
            if (newZero < 0 || newZero >= 9) continue;
            char[] chars = initialStr.toCharArray();
            char temp = chars[zeroIdx];
            chars[zeroIdx] = chars[newZero];
            chars[newZero] = temp;

            int nextState = Integer.parseInt(new String(chars));
            next.add(nextState);
        }
        return next;
    }
}
