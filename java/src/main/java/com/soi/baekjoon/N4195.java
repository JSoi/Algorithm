package com.soi.baekjoon;

import java.io.*;
import java.util.*;

public class N4195 {
    private static Map<String, Set<String>> relationMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            int relationCount = Integer.parseInt(br.readLine());
            relationMap = new HashMap<>();
            for (int r = 0; r < relationCount; r++) {
                String[] line = br.readLine().split(" ");
                String a = line[0];
                String b = line[1];
                relationMap.computeIfAbsent(a, v -> new HashSet<>()).add(b);
                relationMap.computeIfAbsent(b, v -> new HashSet<>()).add(a);
                bw.append(String.valueOf(friendCount(a))).append("\n");
            }
        }
        bw.flush();
    }

    private static int friendCount(String start) {
        HashSet<String> friends = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        friends.add(start);
        // 이미 start,b는 연관되어 있으므로 한 번만 진행
        while (!queue.isEmpty()) {
            String recent = queue.poll();
            for (String f : relationMap.get(recent)) {
                if (friends.contains(f)) {
                    continue;
                }
                queue.offer(f);
                friends.add(f);
            }
        }
        return friends.size();
    }
}
