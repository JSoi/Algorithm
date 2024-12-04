package programmers;

public class L132267 {
    public int solution(int give, int take, int total) {
        int answer = 0;
        while (give <= total && total > 2) {
            total-= give;
            answer += take;
        }
        return answer;
    }
}
