package programmers;

import java.util.Arrays;

public class L92335 {
    public int solution(long n, int k) {
        return (int) Arrays.stream(Long.toString(n, k).split("0"))
                .filter(candidate -> !candidate.isEmpty() && isPrime(Long.parseLong(candidate)))
                .count();
    }

    boolean isPrime(long input) {
        if (input <= 2) {
            return input == 2;
        }
        for (long i = 2; i * i <= input; i++) {
            if (input % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int solution = new L92335().solution(797161, 3);
        int solution2 = new L92335().solution(1031030000, 10);
        System.out.println(solution);
        System.out.println(solution2);
    }
}
