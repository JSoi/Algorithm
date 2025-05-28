package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class N1206 {
    static int[] averageArr; // 1000배한 평균값 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        averageArr = new int[n]; // 정수 배열로 선언

        for (int i = 0; i < n; i++) {
            averageArr[i] = new BigDecimal(br.readLine()).movePointRight(3).intValue();
        }

        int answer = 1;
        while (true) {
            if (isParticipantCount(answer)) {
                System.out.println(answer);
                return;
            }
            answer++;
        }
    }

    private static boolean isParticipantCount(int ppl) {
        for (int avg : averageArr) {
            if (!isBetween(avg, ppl)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isBetween(int scaledAvg, int ppl) {
        for (int sum = ((scaledAvg * ppl + 999) / 1000) * 1000; sum <= ppl * 10000L; sum += 1000) {
            if (sum / ppl == scaledAvg) {
                return true;
            }
        }
        return false;
    }
}
