package programmers;

public class L12952 {
    static final int[][] movements = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {1, 1}, {-1, 1}, {1, -1}, {-1, -1}};

    public static void main(String[] args) {
        int solution = new L12952().solution(4);
        System.out.println(solution);
    }

    static int[] arr;
    static int answer;
    static int N;

    public static int solution(int n) {
        N = n;
        arr = new int[N];
        backTracking(0);
        return answer;
    }

    public static void backTracking(int depth) {
        if (depth == N) {
            answer++;
            return;
        }
        for (int i = 0; i < N; i++) {
            arr[depth] = i;
            if (available(depth)) {
                backTracking(depth + 1);
            }
        }
    }

    public static boolean available(int col) {
        for (int i = 0; i < col; i++) {
            if (arr[i] == arr[col] || Math.abs(col - i) == Math.abs(arr[col] - arr[i])) {
                return false;
            }
        }
        return true;
    }
}
