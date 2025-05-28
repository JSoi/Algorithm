package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N1375 {
    static final String UNDEFINED = "gg";
    static Map<String, Set<String>> rootMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tok = new StringTokenizer(br.readLine(), " ");
        int peopleCount = Integer.parseInt(tok.nextToken());
        rootMap = new HashMap<>();
        int comparisonCount = Integer.parseInt(tok.nextToken());
        for (int i = 0; i < comparisonCount; i++) {
            String[] line = br.readLine().split(" ");
            rootMap.computeIfAbsent(line[0], k -> new HashSet<>()).add(line[1]);
        }
        // query
        int queryCount = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < queryCount; i++) {
            String[] line = br.readLine().split(" ");
            String root = line[0];
            String child = line[1];
            if (isChildOfRoot(root, child, new HashSet<>())) {
                sb.append(root).append(" ");
            } else if (isChildOfRoot(child, root, new HashSet<>())) {
                sb.append(child).append(" ");
            } else {
                sb.append(UNDEFINED).append(" ");
            }
        }
        System.out.println(sb);
    }

    static boolean isChildOfRoot(String root, String target, Set<String> visited) {
        if (!rootMap.containsKey(root)) { // is root
            return false;
        }
        visited.add(root);
        if (rootMap.get(root).contains(target)) {
            return true;
        }
        for (String child : rootMap.get(root)) {
            if (visited.contains(child)) {
                continue;
            }
            if (isChildOfRoot(child, target, visited)) {
                return true;
            }
        }
        return false;
    }
}
