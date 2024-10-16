package programmers;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class L148652 {
    public static void main(String[] args) {
        int solution = new L148652().solution(2, 4, 17);
//        int solution = new L148652().solution(2, 11, 23);
//        int solution = new L148652().solution(2, 1, 2);
//        int solution = new L148652().solution(2, 10, 15);
//        int solution = new L148652().solution(2, 17, 17);
        System.out.println("solution = " + solution);
    }

    static long[] lenArr;
    static long[] oneCountArr;
    static long start;
    static long end;
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
        return (int) find(fromInclusive, toInclusive, n, 0);
    }

    private static long find(long l, long r, int n, int bundleIndex) {
        if (bundleIndex == 2) {
            return 0;
        }
//        System.out.println(l + " - " + r + " - " + bundleIndex);

        long totalCount = lenArr[n];
        long oneCount = oneCountArr[n];
        long bundleCount = totalCount / 5;
        long from = bundleCount * bundleIndex + 1;
        long to = bundleCount * (bundleIndex + 1);

        if (end < from || to < start) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        if (start <= from && end >= to) {
            return oneCount;
        }

        long answer = 0;
        for (int i = 0; i < 5; i++) {
            if(i == 2){
                continue;
            }
            long s = bundleCount * i + 1;
            long e = bundleCount * (i + 1);
//            System.out.println(String.format("%d %d", s,e));
            answer += find(s,e, n - 1, i);
        }
        return answer;
    }

}
