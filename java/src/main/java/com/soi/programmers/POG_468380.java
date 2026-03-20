package com.soi.programmers;

import java.util.Arrays;

public class POG_468380 {
    public static void main(String[] args) {
        long[] sol1 = solution(new int[]{3, 2, 3, 1, 1}, 5, 7);
        // [3, 3, 3, 2, <2, 3, 3>, 3, 1, 1]
        System.out.println(Arrays.toString(sol1));
        System.out.println("{8,2}\n");
    }

    private static long[] startIdx, endIdx, numArr;
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
        long count = slideSum == sum ? 1 : 0;
        int startChunkIdx = 0;
        int endChunkIdx = getIdx(len - 1);

        for (long start = 1, end = start + len - 1; end < maxIdx; start++, end++) {
            if (end > endIdx[endChunkIdx]) endChunkIdx++; // to add
            slideSum += numArr[endChunkIdx] - numArr[startChunkIdx];
            if (start > endIdx[startChunkIdx]) startChunkIdx++; // to subtract
            if (slideSum == sum) count++;
        }
        return new long[]{sum, count};
    }

    private static void init(int[] arr) {
        n = arr.length;
        startIdx = new long[n];
        endIdx = new long[n];
        numArr = Arrays.stream(arr).mapToLong(Integer::valueOf).toArray();

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
