package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class L131130 {
    public static void main(String[] args) {
        int solution = new L131130().solution(new int[]{8, 6, 3, 7, 2, 5, 1, 4});
        System.out.println("solution = " + solution);
    }

    public int solution(int[] cards) {
        int[] map = new int[cards.length];
        Arrays.fill(map, -1);
        int count = 1;
        ArrayList<Integer> list = new ArrayList<>();
        for (int c = 0; c < cards.length; c++) {
            int index = c;
            int subCount = 0;
            while (map[index] == -1) {
                map[index] = count;
                index = cards[index] - 1;
                subCount++;
            }
            if (subCount > 0) {
                list.add(subCount);
            }
            count++;
        }
        list.sort(Collections.reverseOrder());
        return list.size() <= 1 ? 0 : list.get(0) * list.get(1);
    }

}
