package com.soi.baekjoon;

import java.io.*;

public class N2042 {
    static long[] numArr;
    static long[] segmentTree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        int numCount = Integer.parseInt(input[0]);
        int changeCount = Integer.parseInt(input[1]);
        int printCount = Integer.parseInt(input[2]);
        numArr = new long[numCount];
        segmentTree = new long[numCount * 4]; // segment tree
        for (int i = 0; i < numCount; i++) {
            numArr[i] = Long.parseLong(br.readLine());
        }
        init(1, 0, numCount - 1);
        for (int c = 0; c < changeCount + printCount; c++) {
            String[] line = br.readLine().split(" ");
            int caseInteger = Integer.parseInt(line[0]);
            int a = Integer.parseInt(line[1]);
            long b = Long.parseLong(line[2]);
            if (caseInteger == 1) { // 변경
                update(a - 1, b - numArr[a - 1], 1, 0, numCount - 1);
                numArr[a - 1] = b;
            } else { // 출력
                bw.append(String.valueOf(getSum(1, a - 1, (int) (b - 1), 0, numCount - 1))).append("\n");
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }

    private static long getSum(int treeIdx, int from, int to, int left, int right) {
        if (from > right || to < left) {
            return 0; // 범위를 벗어나면 0 반환
        }
        if (from <= left && right <= to) {
            return segmentTree[treeIdx]; // 현재 범위가 완전히 포함되면 값 반환
        }
        int mid = (left + right) / 2;
        return getSum(treeIdx * 2, from, to, left, mid)
                + getSum(treeIdx * 2 + 1, from, to, mid + 1, right);
    }

    private static long init(int treeIndex, int left, int right) {
        if (left == right) {
            return segmentTree[treeIndex] = numArr[left];
        }
        int mid = (left + right) / 2;
        segmentTree[treeIndex] = init(treeIndex * 2, left, mid)
                + init(treeIndex * 2 + 1, mid + 1, right);
        return segmentTree[treeIndex];
    }

    private static void update(int updateIdx, long offset, int treeIdx, int left, int right) {
        if (updateIdx < left || updateIdx > right) {
            return;
        }
        segmentTree[treeIdx] += offset;
        if (left == right) {
            return;
        }
        int mid = (left + right) / 2;
        update(updateIdx, offset, treeIdx * 2, left, mid);
        update(updateIdx, offset, treeIdx * 2 + 1, mid + 1, right);
        segmentTree[treeIdx] = segmentTree[treeIdx * 2] + segmentTree[treeIdx * 2 + 1]; // 부모 노드 갱신
    }
}
