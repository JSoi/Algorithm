package programmers;

import java.util.Arrays;

public class L340198 {
    public static void main(String[] args) {
        int solution = new L340198().solution(new int[]{5, 3, 2}, new String[][]{{"A", "A", "-1", "B", "B", "B", "B", "-1"}, {"A", "A", "-1", "B", "B", "B", "-1", "-1"}, {"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1"}, {"D", "D", "-1", "-1", "-1", "-1", "-1", "-1"}, {"D", "D", "-1", "-1", "-1", "-1", "-1", "F"}, {"D", "D", "-1", "-1", "-1", "-1", "-1", "-1"}});
        System.out.println(solution);
    }

    public int solution(int[] mats, String[][] park) {
        int[][] lengthMatrix = new int[park.length][park[0].length];
        int maxLen = 0;
        for (int r = 0; r < park.length; r++) {
            for (int c = 0; c < park[0].length; c++) {
                if (!park[r][c].equals("-1")) { // 이용 불가 좌석
                    continue;
                }
                int matrixValue = 1;
                if (r - 1 >= 0 && c - 1 >= 0) {
                    // n*n 좌석 생성 가능 시 북, 서, 북서 방향의 값 참조해서 값 할당
                    // 그 외의 경우에는 정사각형이 생성되지 않으므로 matrixValue의 초기값에서 새 값을 할당하지 않는다
                    matrixValue = 1 + Math.min(Math.min(lengthMatrix[r - 1][c], lengthMatrix[r - 1][c - 1]), lengthMatrix[r][c - 1]);
                }
                lengthMatrix[r][c] = matrixValue;
                maxLen = Math.max(maxLen, matrixValue);
            }
        }
        int finalMaxLen = maxLen;
        return Arrays.stream(mats).filter(m -> m <= finalMaxLen).max().orElse(-1);
    }
}
