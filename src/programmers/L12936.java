package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L12936 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new L12936().solution(3, 5)));
    }

    static boolean[] visit;
    static int[] temp;
    static List<int[]> answerList;
    static long targetSize;

    public static int[] solution(int n, long k) {
        answerList = new ArrayList<>();
        visit = new boolean[n];
        temp = new int[n];
        targetSize = k;
        visit(0);
        answerList.stream().map(Arrays::toString).forEach(System.out::println);
        return answerList.get((int) k - 1);
    }

    private static void visit(int count) {
//        System.out.println(count + " | "+ Arrays.toString(temp));
        if (count >= temp.length) {
            answerList.add(temp.clone());
            return;
        }
        for (int i = 0; i < visit.length; i++) {
            if (!visit[i] && answerList.size() < targetSize) {
                visit[i] = true;
                temp[count] = i + 1;
                visit(count + 1);
                visit[i] = false;
            }
        }
    }
}
