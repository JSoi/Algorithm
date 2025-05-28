package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class N17298 {
    static int[] arr;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(buf.readLine());
        arr = new int[cnt];
        result = new int[cnt];
        StringTokenizer tok = new StringTokenizer(buf.readLine());
        for (int i = 0; i < cnt; i++) {
            arr[i] = Integer.parseInt(tok.nextToken());
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < cnt; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                arr[stack.pop()] = arr[i];
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            arr[stack.pop()] = -1;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cnt; i++) {
            sb.append(arr[i]).append(' ');
        }
        System.out.println(sb);
    }

}
