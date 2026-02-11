package com.soi.programmers;

public class POG_148652 {
    static long[] lenArr;
    static long[] oneCountArr;
    static long start;
    static long end;

    public static void main(String[] args) {
        int solution = solution(2, 4, 17);
//        int solution = new POG_148652().solution(2, 11, 23);
//        int solution = new POG_148652().solution(2, 1, 2);
//        int solution = new POG_148652().solution(2, 10, 15);
//        int solution = new POG_148652().solution(2, 17, 17);
        System.out.println("solution = " + solution);
    }

    public static int solution(int n, long fromInclusive, long toInclusive) {
        lenArr = new long[n + 1];
        oneCountArr = new long[n + 1];
        start = fromInclusive;
        end = toInclusive;
        long len = 1;
        long oneCount = 1;
        for (int i = 0; i <= n; i++) {
            lenArr[i] = len;
            oneCountArr[i] = oneCount;
            len *= 5;
            oneCount *= 4;
        }
        return (int) find(n, fromInclusive, toInclusive);
    }

    private static long find(int n, long s, long e) {
        if (n == 0) {
            return 1;
        }
        long totalCount = lenArr[n];
        long bundleCount = totalCount / 5;

        long answer = 0;
        for (int i = 0; i < 5; i++) {
            long bundleStart = bundleCount * i + 1;
            long bundleEnd = bundleCount * (i + 1);
            if (i == 2 || e < bundleStart || s > bundleEnd) {
                continue;
            }
            if (s <= bundleStart && e >= bundleEnd) {
                answer += oneCountArr[n] / 4;
            } else {
                answer += find(n - 1, Math.max(bundleStart, s) - i * bundleCount, Math.min(e, bundleEnd) - i * bundleCount);
            }
        }
        return answer;
    }

}
