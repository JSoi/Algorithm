package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1244 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        boolean[] arr = new boolean[count];
        StringTokenizer tok = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < count; i++) {
            arr[i] = tok.nextToken().equals("1");
        }
        int caseCount = Integer.parseInt(br.readLine());
        for (int i = 0; i < caseCount; i++) {
            String[] input = br.readLine().split(" ");
            int isBoy = Integer.parseInt(input[0]);
            int num = Integer.parseInt(input[1]);
            if (isBoy == 1) {
                boy(num, arr);
            } else {
                girl(num - 1, arr);
            }
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i] ? 1 : 0).append(" ");
            if ((i+1) % 20 == 0) {
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }

    static void girl(int num, boolean[] arr) {
        arr[num] = !arr[num];
        for (int i = 1; num - i >= 0 && num + i < arr.length && arr[num - i] == arr[num + i]; i++) {
            arr[num + i] = !arr[num + i];
            arr[num - i] = !arr[num - i];
        }
    }

    static void boy(int num, boolean[] arr) {
        int no = num - 1;
        while (no < arr.length) {
            arr[no] = !arr[no];
            no += num;
        }
    }
}
