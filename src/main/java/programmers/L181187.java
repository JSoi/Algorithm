package programmers;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/181187">두 원 사이의 정수 쌍</a>
 */
public class L181187 {


    public long solution(int r1, int r2) {
        long answer = 0;
        for (int x = 1; x <= r2; x++) {
            long r1Y = (long) Math.ceil(Math.sqrt((double) r1 * r1 - (double) x * x));
            long r2Y = (long) Math.floor(Math.sqrt((double) r2 * r2 - (double) x * x));
            answer += (r2Y - r1Y + 1);
        }
        return answer * 4;
    }


    public static void main(String[] args) {
        System.out.println(new L181187().solution(1, 2)); //12
    }
}
