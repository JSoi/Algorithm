package programmers;

import java.util.Arrays;

public class L12923 {
    public static void main(String[] args) {
        long[] solution = new L12923().solution(9000500, 10000000);
        System.out.println(Arrays.toString(solution));
    }

    public long[] solution(long begin, long end) {
        long[] answer = new long[(int) (end - begin + 1)];
        for (long i = begin; i <= end; i++) {
            answer[(int) (i - begin)] = getBlock(i);
        }
        return answer;
    }

    private long getBlock(long input) {
        if (input == 1) {
            return 0;
        }
        for (long i = input / 2; i >= 2; i--) {
            if (input % i == 0) {
                return i;
            }
        }
        return 1;
    }
}
