package com.soi.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public class POG_150366 {
    static String[] charts = new String[2500];
    static int[] parent = new int[2500];

    public static void main(String[] args) {
        String[] sol = solution(new String[]{"UPDATE 1 1 menu", "UPDATE 1 2 category", "UPDATE 2 1 bibimbap",
                "UPDATE 2 2 korean", "UPDATE 2 3 rice", "UPDATE 3 1 ramyeon", "UPDATE 3 2 korean", "UPDATE 3 3 noodle",
                "UPDATE 3 4 instant", "UPDATE 4 1 pasta", "UPDATE 4 2 italian", "UPDATE 4 3 noodle", "MERGE 1 2 1 3",
                "MERGE 1 3 1 4", "UPDATE korean hansik", "UPDATE 1 3 group", "UNMERGE 1 4", "PRINT 1 3", "PRINT 1 4"});
        System.out.println(Arrays.toString(sol));
    }

    public static String[] solution(String[] commands) {
        ArrayList<String> answer = new ArrayList<>();
        charts = new String[2500];
        parent = IntStream.range(0, 2500).toArray();
        for (String command : commands) {
            String[] cs = command.split(" ");
            switch (cs[0]) {
                case "UPDATE" -> {
                    if (cs.length == 4) {
                        update(Integer.parseInt(cs[1]) - 1, Integer.parseInt(cs[2]) - 1, cs[3]);
                    } else {
                        String before = cs[1];
                        String after = cs[2];
                        updateValue(before, after);
                    }
                }
                case "MERGE" -> {
                    merge(Integer.parseInt(cs[1]) - 1, Integer.parseInt(cs[2]) - 1,
                            Integer.parseInt(cs[3]) - 1, Integer.parseInt(cs[4]) - 1);
                }
                case "UNMERGE" -> {
                    unmerge(Integer.parseInt(cs[1]) - 1, Integer.parseInt(cs[2]) - 1);
                }
                case "PRINT" -> {
                    answer.add(print(Integer.parseInt(cs[1]) - 1, Integer.parseInt(cs[2]) - 1));
                }
            }
        }
        return answer.toArray(String[]::new);
    }


    private static String print(int r, int c) {
        String value = find(r, c);
        return value == null ? "EMPTY" : value;
    }

    private static void updateValue(String bf, String af) {
        for (int i = 0; i < charts.length; i++) {
            if (charts[i] != null && charts[i].equals(bf)) {
                charts[i] = af;
            }
        }
    }

    private static void update(int r, int c, String after) {
        charts[findParent(r, c)] = after;
    }

    private static String find(int r, int c) {
        return charts[findParent(r, c)];
    }

    private static int findParent(int r, int c) {
        int idx = idx(r, c);
        if (parent[idx] == idx) {
            return idx;
        }
        return parent[idx] = findParent(parent[idx] / 50, parent[idx] % 50);
    }

    private static void merge(int r1, int c1, int r2, int c2) {
        if (r1 == r2 && c1 == c2) {
            return;
        }
        String one = find(r1, c1);
        if (one != null) {
            parent[findParent(r2, c2)] = findParent(r1, c1);
        } else {
            parent[findParent(r1, c1)] = findParent(r2, c2);
        }
    }

    private static void unmerge(int r, int c) {
        int target = findParent(r, c);
        String beforeValue = charts[target];
        boolean[] toChange = new boolean[2500];
        for (int i = 0; i < 2500; i++) {
            if (findParent(i / 50, i % 50) == target) {
                toChange[i] = true;
            }
        }
        for (int i = 0; i < 2500; i++) {
            if (toChange[i]) {
                parent[i] = i;
                charts[i] = null;
            }
        }
        charts[idx(r, c)] = beforeValue;
    }

    private static int idx(int r, int c) {
        return r * 50 + c;
    }
}
