package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_14891 {
    private static int[] upPos = new int[5];
    private static int[][] cogWheel = new int[5][8];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 1; i <= 4; i++) {
            cogWheel[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }
        int rotate = Integer.parseInt(br.readLine());
        for (int i = 0; i < rotate; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            rotate(a, b);
        }
        int answer = 0;
        for (int i = 1; i <= 4; i++) {
            if (cogWheel[i][upPos[i]] == 1) {
                answer += (1 << (i - 1));
            }
        }
        System.out.println(answer);
    }

    private static void rotate(int target, int dir) { // dir 1 : 시계, -1 : 반시계
        int[] move = new int[5];
        move[target] = dir;

        int left = target - 1;
        int leftRotate = dir;

        // 왼쪽 전파
        while (left >= 1) {
            int right9 = (upPos[left + 1] + 6) % 8;
            int current3 = (upPos[left] + 2) % 8;
            if (cogWheel[left][current3] == cogWheel[left + 1][right9]) { // 같은 극이면 회전하지 않음
                break;
            }
            // 다른 극이면 반대로 회전
            leftRotate = -leftRotate;
            move[left] = leftRotate;
            left--;
        }

        // 오른쪽 전파
        int right = target + 1;
        int rightRotate = dir;
        while (right <= 4) {
            int left3 = (upPos[right - 1] + 2) % 8;
            int current9 = (upPos[right] + 6) % 8;
            if (cogWheel[right][current9] == cogWheel[right - 1][left3]) { // 같은 극이면 회전하지 않음
                break;
            }
            rightRotate = -rightRotate;
            move[right] = rightRotate;
            right++;
        }
        for (int i = 1; i < move.length; i++) {
            if (move[i] == 0) continue;
            upPos[i] = (upPos[i] + (move[i] == -1 ? 1 : 7)) % 8;
        }
    }
}
