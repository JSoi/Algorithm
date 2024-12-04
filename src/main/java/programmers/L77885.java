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
            long number = createNumber(n);
            answer[answerIndex++] = number;
        }
        return answer;
    }

    static long createNumber(long a) {
        if ((a & 1L) == 0 || (a & 2L) == 0) {
            return a + 1L;
        }
        long move = 1L;
        while (true) {
            if (((1L << move) & a) == 0) { // 00, 10
                return a | (1L << (move));
            } else if (((2L << move) & a) == 0) { // 01
                return (a + 1) | (1L << (move)) - 1;
            }
            move++;
        }
    }
}
