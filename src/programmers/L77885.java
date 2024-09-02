package programmers;

import java.util.Arrays;

public class L77885 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new L77885().solution(new long[]{2, 7})));

    }

    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        int answerIndex = 0;
        for (long n : numbers) {
            long another = n + 1;
            while (true) {
                if (differenceCount(n, another) <= 2) {
                    answer[answerIndex++] = another;
                    break;
                }
                another++;
            }
        }
        return answer;
    }

    static int differenceCount(long a, long b) {
        long xor = a ^ b;
        int diffCount = 0;
        while (xor > 0) {
            if (xor % 2 == 1) {
                diffCount++;
            }
            xor /= 2;
        }
        return diffCount;
    }
}
