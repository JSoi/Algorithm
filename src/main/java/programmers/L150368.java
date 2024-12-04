package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L150368 {
    public static void main(String[] args) {
        int[] solution = new L150368().solution(new int[][]{{40, 10000}, {25, 10000}}, new int[]{7000, 9000});
        System.out.println(Arrays.toString(solution));
    }

    static List<int[]> emoticonDiscountList;
    static int[] emoticonsArr;
    static final int[] discount = new int[]{10, 20, 30, 40};

    public static int[] solution(int[][] users, int[] emoticons) {
        emoticonsArr = emoticons;
        emoticonDiscountList = new ArrayList<>();
        createDiscount(0, new int[emoticons.length]);
        int subscribers = 0;
        int money = 0;
        for (int[] dList : emoticonDiscountList) {
            int subCount = 0;
            int userBought = 0;
            for (int[] user : users) {
                int eachBoughtAmount = 0;
                for (int d = 0; d < dList.length; d++) {
                    if (dList[d] >= user[0]) {
                        eachBoughtAmount += emoticons[d] * (100 - dList[d]) / 100;
                    }
                }
                if (eachBoughtAmount >= user[1]) {
                    subCount++;
                } else {
                    userBought += eachBoughtAmount;
                }
            }
            // sum up
            if (subscribers < subCount) {
                subscribers = subCount;
                money = userBought;
            } else if (subscribers == subCount) {
                money = Math.max(money, userBought);
            }
        }
        return new int[]{subscribers, money};
    }

    private static void createDiscount(int index, int[] temp) {
        if (index == emoticonsArr.length) {
            emoticonDiscountList.add(temp);
            return;
        }
        for (int d : discount) {
            temp[index] = d;
            createDiscount(index + 1, Arrays.copyOf(temp, temp.length));
        }
    }
}
