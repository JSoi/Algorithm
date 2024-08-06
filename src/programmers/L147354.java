package programmers;

import tool.Assertions;

import java.util.Arrays;

public class L147354 {
    public static void main(String[] args) throws Exception {
        int solution = new L147354().solution(new int[][]{{2, 2, 6}, {1, 5, 10}, {4, 2, 9}, {3, 8, 3}}, 2, 2, 3);
        Assertions.check(solution, 4);
    }

    public int solution(int[][] data, int col, int rowBegin, int rowEnd) {
        int answer = 0;
        Arrays.sort(data, (d1, d2) ->
                d1[col - 1] - d2[col - 1] == 0 ? d2[0] - d1[0] : d1[col - 1] - d2[col - 1]);
        for (int index = rowBegin - 1; index < rowEnd; index++) {
            int finalIndex = index;
            int sum = Arrays.stream(data[index]).map(d -> d % (finalIndex + 1)).sum();
            answer ^= sum;
        }
        return answer;
    }
}
