package com.soi.baekjoon;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class BOJ_4195 {
    private static Map<String, Integer> friendIndexMap;
    private static int nameCount;
    private static int[] root;
    private static int[] size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            int relationCount = Integer.parseInt(br.readLine());
            nameCount = 0;
            root = new int[relationCount * 2];
            size = new int[relationCount * 2];
            for (int k = 0; k < relationCount * 2; k++) {
                root[k] = k;
                size[k] = 1;
            }
            friendIndexMap = new HashMap<>();
            for (int r = 0; r < relationCount; r++) {
                String[] line = br.readLine().split(" ");
                String a = line[0], b = line[1];
                int aIdx = getIdx(a), bIdx = getIdx(b);
                union(aIdx, bIdx);
                int root = find(aIdx);
                bw.append(String.valueOf(size[root])).append("\n");
            }
        }
        br.close();
        bw.flush();
        bw.close();
    }

    private static void union(int a, int b) {
        int aa = find(a), bb = find(b);
        if (aa == bb) {
            return;
        }
        root[bb] = aa;
        size[aa] += size[bb];
    }

    private static int getIdx(String name) {
        friendIndexMap.putIfAbsent(name, nameCount++);
        return friendIndexMap.get(name);
    }

    private static int find(int target) {
        if (root[target] == target) return target;
        return root[target] = find(root[target]);
    }
}
