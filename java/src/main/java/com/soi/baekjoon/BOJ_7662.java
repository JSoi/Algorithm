package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 * <a href = "https://www.acmicpc.net/problem/7662">이중 우선순위 큐</a>
 */
public class BOJ_7662 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < testCases; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n][2];
            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                arr[j][0] = st.nextToken().charAt(0) == 'I' ? 1 : 0;
                arr[j][1] = Integer.parseInt(st.nextToken());

            }
            TestCase test = new TestCase(arr);
            if (test.map.isEmpty()) {
                sb.append("EMPTY");
            } else {
                sb.append(test.map.lastKey()).append(" ").append(test.map.firstKey());
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    private static class TestCase {
        int[][] cases;
        TreeMap<Integer, Integer> map;

        public TestCase(int[][] cases) {
            this.cases = cases;
            map = new TreeMap<>();
            for (int[] aCase : cases) {
                // insert = 1
                // delete = 1
                int num = aCase[1];
                if (aCase[0] == 1) {
                    map.put(num, map.getOrDefault(num, 0) + 1);
                } else {
                    if (map.isEmpty()) continue;
                    int target = (num == 1) ? map.lastKey() : map.firstKey();
                    int count = map.get(target);
                    if (count == 1) {
                        map.remove(target);
                    } else {
                        map.put(target, count - 1);
                    }
                }
            }
        }
    }
}
