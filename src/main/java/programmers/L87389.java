package programmers;

public class L87389 {
    public int solution(int n) {
        int answer;
        for (answer = 2; answer < n; answer++) {
            if (n % answer == 1) {
                return answer;
            }
        }
        return -1;
    }
}
