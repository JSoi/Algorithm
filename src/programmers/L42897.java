package programmers;

import java.util.*;

public class L42897 {

    public static void main(String[] args) {
        int solution = new L42897().solution(new int[]{1, 2, 3, 1});
        int solution2 = new L42897().solution(new int[]{1, 2, 3});
        System.out.println("solution = " + solution);
    }

    public int solution(int[] money) {
        int len = money.length;
        if (len <= 2) {
            return Arrays.stream(money).max().orElse(0);
        }
        int withFirstHouse = rob(money, 0, len - 2);
        int withoutFirstHouse = rob(money, 1, len - 1);

        return Math.max(withFirstHouse, withoutFirstHouse);
    }

    int rob(int[] money, int start, int end) {
        int p = 0, pp = 0;
        for (int i = start; i <= end; i++) {
            int current = Math.max(p, pp + money[i]);
            pp = p;
            p = current;
        }
        return p;
    }
}
