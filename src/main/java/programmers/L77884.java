package programmers;

public class L77884 {
    public int solution(int left, int right) {
        int answer = 0;
        for (int target = left; target <= right; target++) {
            if (divisor(target) % 2 == 0) {
                answer += target;
            } else {
                answer -= target;
            }
        }
        return answer;
    }

    public int divisor(int multiple) {
        int answer = 0;
        for (int i = 1; i <= multiple; i++) {
            if (multiple % i == 0) {
                answer++;
            }
        }
        return answer;
    }
}
