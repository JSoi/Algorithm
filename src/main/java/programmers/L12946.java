package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L12946 {
    static List<int[]> answer = new ArrayList<>();

    public int[][] solution(int n) {
        hanoi(n, 1, 3, 2);
        return answer.toArray(new int[0][0]);
    }

    void hanoi(int n, int from, int to, int via) {
        if (n == 1) {
            answer.add(new int[]{from, to});
            return;
        }
        hanoi(n - 1, from, via, to);
        answer.add(new int[]{from, to});
        hanoi(n - 1, via, to, from);
    }


    public static void main(String[] args) {
        int[][] solution = new L12946().solution(2);
        for (int[] ints : solution) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
