package programmers;

public class L12979 {
    public static void main(String[] args) {
//        int solution = new L12979().solution(11, new int[]{4, 11}, 1);
        int solution = new L12979().solution(16, new int[]{9}, 2);
        System.out.println("solution = " + solution);
    }

    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        // 빈칸을 나누자
        int start = 1;
        int wid = 2 * w + 1;
        for (int s : stations) {
            int left = s - w - start;
            if (left > 0) {
                answer += (int) Math.ceil((double) left / wid);
            }
            start = s + w + 1;
        }
        if (start <= n) {
            answer += (int) Math.ceil((double) (n - start + 1) / wid);
        }
        return answer;
    }
}
