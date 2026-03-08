package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.BiPredicate;

public class BOJ_1208 {
    private static int[] arr;
    private static long answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        List<Long> left = new ArrayList<>();
        List<Long> right = new ArrayList<>();
        int mid = n / 2; // 5 -> 2
        for (int i = 1; i <= mid; i++) {
            comb(mid, 0, 0, i, 0, left);
        }
        for (int i = 1; i <= n - mid; i++) {
            comb(n, mid, 0, i, 0, right);
        }

        Collections.sort(left);
        Collections.sort(right);

//        System.out.println(left);
//        System.out.println(right);

        // consider lower_bound, upper_bound
        // on left side
        for (long l : left) {
            if (l == s) {
                answer++; // for left subsets
            }
            // right side occurrences
            int lb = bound(s - l, right, (a, b) -> a < b);
            int ub = bound(s - l, right, (a, b) -> a <= b);
            answer += ub - lb;
        }

        // count single for right subsets
        for (long r : right) {
            if (r == s) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    private static void comb(int n, int r, int count, int countTotal, long sum, List<Long> result) {
        if (count == countTotal) {
            result.add(sum);
            return;
        }
        if (r == n) {
            return;
        }
        for (int i = r; i < n; i++) {
            comb(n, i + 1, count + 1, countTotal, sum + arr[i], result);
        }
    }

    private static int bound(long target, List<Long> list, BiPredicate<Long, Long> dir) {
        int l = 0, r = list.size();
        while (l < r) {
            int m = (l + r) >>> 1;
            long value = list.get(m);
            if (dir.test(value, target)) l = m + 1;
            else r = m;
        }
        return l;
    }

}
