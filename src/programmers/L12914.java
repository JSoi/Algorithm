package programmers;

import tool.Assertions;

import java.util.Arrays;

public class L12914 {
    public static void main(String[] args) throws Exception {
        long solution1 = new L12914().solution(4);// 5
//        long solution2 = new L12914().solution(3); // 3
        Assertions.check(solution1, 5L);
//        Assertions.check(solution2, 3L);
    }

    static long arrival;
    static long[] arr;
    public long solution(int n) {
        arr = new long[n + 1];
        arrival = n;
        for (int i = n - 1; i >= 0; i--) {
            jump(i);
        }
        return arr[0];
    }

    private static void jump(int index) {
        if (index == arrival - 1 || index == arrival - 2) {
            arr[index] = arrival - index;
            return;
        }
        long afterOneStep = index + 1 >= arrival ? 0 : arr[index + 1];
        long afterTwoStep = index + 2 >= arrival ? 0 : arr[index + 2];
        arr[index] = afterOneStep + afterTwoStep;
    }
}
