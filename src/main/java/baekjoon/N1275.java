package baekjoon;

import java.io.*;
import java.util.Arrays;

public class N1275 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int turnCount = Integer.parseInt(br.readLine().split(" ")[1]);
        long[] arr = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        SegmentTree segmentTree = new SegmentTree(arr);
        for (int i = 0; i < turnCount; i++) {
            long[] lineInput = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
            int start = (int) Math.min(lineInput[0] - 1, lineInput[1] - 1);
            int end = (int) Math.max(lineInput[0] - 1, lineInput[1] - 1);
            int changeIdx = (int) (lineInput[2] - 1);
            long changeValue = lineInput[3];

            long rangeSum = segmentTree.query(start, end);
            bw.append(String.valueOf(rangeSum)).append("\n");

            segmentTree.update(changeIdx, changeValue);
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static class SegmentTree {
        private long[] tree;
        private long[] arr;
        private int n;

        public SegmentTree(long[] arr) {
            this.n = arr.length;
            this.arr = arr.clone();
            this.tree = new long[4 * n]; // 세그먼트 트리 배열
            buildTree(0, n - 1, 1);
        }

        // 세그먼트 트리 생성
        private void buildTree(int start, int end, int node) {
            if (start == end) {
                tree[node] = arr[start];
                return;
            }
            int mid = (start + end) / 2;
            buildTree(start, mid, node * 2);
            buildTree(mid + 1, end, node * 2 + 1);
            tree[node] = tree[node * 2] + tree[node * 2 + 1];
        }

        public long query(int left, int right) {
            return query(0, n - 1, 1, left, right);
        }

        private long query(int start, int end, int node, int left, int right) {
            if (right < start || end < left) {
                return 0;
            }
            if (left <= start && end <= right) {
                return tree[node];
            }
            int mid = (start + end) / 2;
            long leftSum = query(start, mid, node * 2, left, right);
            long rightSum = query(mid + 1, end, node * 2 + 1, left, right);
            return leftSum + rightSum;
        }

        public void update(int idx, long value) {
            update(0, n - 1, 1, idx, value);
        }

        private void update(int start, int end, int node, int idx, long value) {
            if (start == end) {
                tree[node] = value;
                arr[idx] = value;
                return;
            }
            int mid = (start + end) / 2;
            if (idx <= mid) {
                update(start, mid, node * 2, idx, value);
            } else {
                update(mid + 1, end, node * 2 + 1, idx, value);
            }
            tree[node] = tree[node * 2] + tree[node * 2 + 1];
        }
    }
}
