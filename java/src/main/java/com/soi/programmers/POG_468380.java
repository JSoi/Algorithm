package com.soi.programmers;

import java.util.Arrays;

public class POG_468380 {
    public static void main(String[] args) {
        long[] sol = solution(new int[]{2, 2, 2}, 2, 2);
        System.out.println(Arrays.toString(sol));
        System.out.println("{2,6}\n");
    }

    private static long[] startIdx;
    private static long[] endIdx;
    private static int[] numArr;
    private static long[] sumDP;
    private static int n;

    // 시작 인덱스, 누적 합
    public static long[] solution(int[] arr, long l, long r) {
        l--;
        r--;

        init(arr);

        long sum = getSum(l, r);
        long len = r - l + 1;
        long maxIdx = startIdx[n - 1] + arr[n - 1];

        long slideSum = getSum(0, len - 1);
        long count = 0;
        long start = 0;
        long end = start + len - 1;
        int startChunkIdx = 0;
        int endChunkIdx = getIdx(end);

        while (end < maxIdx && startChunkIdx < n && endChunkIdx < n) {
            long lLeftOver = endIdx[startChunkIdx] - start + 1;
            long rLeftOver = endIdx[endChunkIdx] - end + 1;

            long moveCount = Math.min(lLeftOver, rLeftOver);
            int offset = arr[endChunkIdx] - arr[startChunkIdx];
            if (slideSum == sum && offset == 0) {
                count += moveCount;
            } else if (isReachableSum(slideSum, moveCount - 1, sum, offset)) {
                count++;
            }

            start += moveCount;
            end = start + len - 1;
            slideSum += offset * (moveCount - 1);
            slideSum -= numArr[startChunkIdx];

            while (startChunkIdx < n && endIdx[startChunkIdx] < start) {
                startChunkIdx++;
            }
            while (endChunkIdx < n && endIdx[endChunkIdx] < end) {
                endChunkIdx++;
            }
            if (endChunkIdx < n) {
                slideSum += numArr[endChunkIdx];
            }
        }
        return new long[]{sum, count};
    }

    private static boolean isReachableSum(long start, long count, long target, int offset) {
        if (start == target) {
            return true;
        }
        if (offset == 0) {
            return false;
        }
        long diff = target - start;
        return Long.signum(diff) * offset > 0 && diff / offset <= count && diff % offset == 0;
    }

    private static void init(int[] arr) {
        n = arr.length;
        startIdx = new long[n];
        endIdx = new long[n];
        numArr = arr;
        long idx = 0;
        sumDP = new long[n];
        sumDP[0] = (long) arr[0] * arr[0];

        for (int a = 0; a < arr.length; a++) {
            startIdx[a] = idx;
            idx += arr[a];
            endIdx[a] = idx - 1;
            if (a > 0) {
                sumDP[a] = (long) arr[a] * arr[a] + sumDP[a - 1];
            }
        }
    }

    private static long getSum(long l, long r) {
        int fromIdx = getIdx(l);
        int toIdx = getIdx(r);
        if (toIdx == fromIdx) { // same section
            return numArr[fromIdx] * (r - l + 1);
        }
        long leftSum = (numArr[fromIdx] - l + startIdx[fromIdx]) * numArr[fromIdx];
        long rightSum = (r - startIdx[toIdx] + 1) * numArr[toIdx];
        return leftSum + rightSum + (toIdx - fromIdx == 1 ? 0 : sumDP[toIdx - 1] - sumDP[fromIdx]);
    }

    private static int getIdx(long idx) {
        int left = 0;
        int right = n - 1;
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (startIdx[mid] <= idx) {
                left = mid;
            } else if (startIdx[mid] > idx) {
                right = mid - 1;
            }
        }
        return left;
    }
}

