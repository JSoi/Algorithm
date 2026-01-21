package com.soi.baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class N4256 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());
        while (testCase-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] preOrderArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] inOrderArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            CreateTree tree = new CreateTree(n, preOrderArr, inOrderArr);
            bw.write(tree.solve() + "\n");
        }
        bw.flush();
    }

    private static class CreateTree {
        int n;
        int[] inorderArr;
        int[] preorderArr;
        int[] preorderIdx;
        List<Integer> answer;

        public CreateTree(int n, int[] preorderArr, int[] inorderArr) {
            this.n = n;
            this.preorderArr = preorderArr;
            this.inorderArr = inorderArr;
            // create preorderIdx
            this.preorderIdx = new int[n + 1];
            for (int i = 0; i < preorderArr.length; i++) {
                preorderIdx[preorderArr[i]] = i;
            }
            answer = new ArrayList<>();
        }

        public String solve() {
            travel(0, inorderArr.length - 1);
            return answer.stream().map(String::valueOf).collect(Collectors.joining(" "));
        }

        private void travel(int start, int end) {
            if (end < start) {
                return;
            }
            int rootIdx = start;
            // preorder를 참고하여 가장 낮은 인덱스일 경우 root로 지정, 루트를 제외한 좌/우를 나눠준다
            for (int i = start; i <= end; i++) {
                if (preorderIdx[inorderArr[rootIdx]] > preorderIdx[inorderArr[i]]) {
                    rootIdx = i;
                }
            }
            travel(start, rootIdx - 1); // left
            travel(rootIdx + 1, end); // right
            answer.add(inorderArr[rootIdx]);
        }
    }
}
