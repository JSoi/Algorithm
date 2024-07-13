package programmers;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/86971">전력망 둘로 나누기</a>
 */
public class L86971 {
    public int solution(int n, int[][] wires) {
        int answer = -1;
        Arrays.sort(wires, Comparator.comparingInt(a -> a[0]));
        int[] tree = new int[n + 1];
        Arrays.fill(tree, -1);
        for (int[] wire : wires) {
            tree[wire[0]] = wire[1];
        }
        return answer;
    }
    public static void main(String[] args) {

    }
}
