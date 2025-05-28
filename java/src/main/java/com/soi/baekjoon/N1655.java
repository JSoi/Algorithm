package com.soi.baekjoon;

import java.io.*;
import java.util.*;

public class N1655 {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = Integer.parseInt(br.readLine());
        for (int i = 0; i < count; i++) {
            int target = Integer.parseInt(br.readLine());
            insert(list, target);
            bw.append(String.valueOf(list.get((list.size() - 1) / 2))).append("\n");
        }
        bw.flush();
    }

    private static void insert(List<Integer> list, int element) {
        int pos = findPosition(list, element);
        list.add(pos, element);
    }

    private static int findPosition(List<Integer> list, int element) {
        int start = 0;
        int end = list.size();
        int mid = 0;
        while (start < end) {
            mid = (start + end) / 2;
            if (list.get(mid) < element) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
}
