package programmers;

import tool.Assertions;

public class L140107 {
    public static void main(String[] args) throws Exception {
        Assertions.check(new L140107().solution(2, 4), 6L);
    }

    public long solution(int k, int d) {
        long answer = 0;
        for (long mul = 0; mul <= d; mul += k) {
            int diff = (int) Math.floor(Math.sqrt(Math.pow(d, 2) - Math.pow(mul, 2))) / k;
            answer += (diff + 1);
        }
        return answer;
    }
}
