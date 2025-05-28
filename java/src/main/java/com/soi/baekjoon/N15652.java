package com.soi.baekjoon;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class N15652 {
    static List<int[]> answerList;
    static int N, M;

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();
        scan.close();
        answerList = new ArrayList<>();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        travel(1, 0, new int[M]);
        for (int[] al : answerList) {
            bw.append(Arrays.stream(al).boxed().map(String::valueOf).collect(Collectors.joining(" ")))
                    .append("\n");
        }
        bw.flush();
    }

    private static void travel(int curr, int totalCount, int[] answer) {
        if (curr > N) {
            return;
        }
        if (totalCount == M) {
            answerList.add(answer);
            return;
        }
        for (int i = curr; i <= N; i++) {
            int[] temp = answer.clone();
            temp[totalCount] = i;
            travel(i, totalCount + 1, temp);
        }
    }
}
