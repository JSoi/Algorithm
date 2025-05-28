package com.soi.baekjoon;

import java.util.*;

public class N1461 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 책 개수
        int M = sc.nextInt(); // 최대 들 수 있는 책 수

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int book = sc.nextInt();
            if (book < 0) left.add(Math.abs(book));
            else right.add(book);
        }

        left.sort(Collections.reverseOrder());
        right.sort(Collections.reverseOrder());

        int maxDistance = 0;
        int total = 0;

        // 왼쪽 처리
        for (int i = 0; i < left.size(); i += M) {
            total += left.get(i) * 2;
            maxDistance = Math.max(maxDistance, left.get(i));
        }

        // 오른쪽 처리
        for (int i = 0; i < right.size(); i += M) {
            total += right.get(i) * 2;
            maxDistance = Math.max(maxDistance, right.get(i));
        }

        total -= maxDistance; // 가장 먼 거리 왕복 제거
        System.out.println(total);
    }
}
