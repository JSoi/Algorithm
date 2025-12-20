package com.soi.baekjoon;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class N2263 {
    static int[] inorder, postorder;
    static Map<Integer, Integer> inorderIdxMap = new HashMap<>();
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        inorder = new int[n];
        postorder = new int[n];
        StringTokenizer tok = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(tok.nextToken());
            inorder[i] = value;
            inorderIdxMap.put(value, i);
        }
        tok = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            postorder[i] = Integer.parseInt(tok.nextToken());
        }
        br.close();
        build(0, n - 1, 0, n - 1);
        bw.flush();
    }

    static void build(int inS, int inE, int postS, int postE) throws IOException {
        if (inS > inE || postS > postE) return;

        int root = postorder[postE];
        bw.write(root + " ");

        int rootIdx = inorderIdxMap.get(root);
        int leftSize = rootIdx - inS;

        build(inS, rootIdx - 1, postS, postS + leftSize - 1);
        build(rootIdx + 1, inE, postS + leftSize, postE - 1);
    }
}
