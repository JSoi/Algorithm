package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * <a href = "">https://www.acmicpc.net/problem/1092</a>
 */
public class BOJ_1092_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int crainCount = Integer.parseInt(br.readLine());
        int[] crain = new int[crainCount];
        StringTokenizer tok = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < crainCount; i++) {
            crain[i] = Integer.parseInt(tok.nextToken());
        }
        int boxCount = Integer.parseInt(br.readLine());
        List<Integer> boxs = new LinkedList<>();
        tok = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < boxCount; i++) {
            boxs.add(Integer.parseInt(tok.nextToken()));
        }
        int time = 0;
        boxs.sort(Collections.reverseOrder());
        crain = Arrays.stream(crain).boxed().sorted((a, b) -> b - a).mapToInt(Integer::valueOf).toArray();
        while (!boxs.isEmpty()) {
            if (boxs.get(0) > crain[0]) {
                System.out.println(-1);
                return;
            }
            Iterator<Integer> boxIterator = boxs.iterator();
            for (int crainIdx = 0; crainIdx < crainCount; crainIdx++) {
                while (boxIterator.hasNext()) {
                    int next = boxIterator.next();
                    if (next <= crain[crainIdx]) {
                        boxIterator.remove();
                        break;
                    }
                }
            }
            time++;
        }
        System.out.println(time);
    }
}
