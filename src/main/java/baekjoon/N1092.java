package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N1092 {
    private static int[][] price;
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int pplCount = Integer.parseInt(br.readLine());
        price = new int[pplCount][pplCount];
        for (int i = 0; i < pplCount; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < pplCount; j++) {
                price[i][j] = line[j] - '0';
            }
        }
        boolean[] possess = new boolean[pplCount];
        possess[0] = true;
        answer = 1;
        sell(0, 0, possess);
        System.out.println(answer);
    }

    private static void sell(int owner, int currentPrice, boolean[] possess) {
        // 판매 불가 시 업데이트
        if (!ableToSell(currentPrice, price[owner], possess)) {
            answer = Math.max(countCustomers(possess), answer);
            return;
        }
        for (int i = 0; i < price.length; i++) {
            if (possess[i] || price[owner][i] < currentPrice) {
                continue;
            }
            possess[i] = true;
            sell(i, price[owner][i], possess);
            possess[i] = false;
        }
    }

    private static int countCustomers(boolean[] possess) {
        int count = 0;
        for (boolean b : possess) {
            if (b) {
                count++;
            }
        }
        return count;
    }

    private static boolean ableToSell(int price, int[] customer, boolean[] possess) {
        for (int i = 0; i < customer.length; i++) {
            if (!possess[i] && customer[i] >= price) {
                return true;
            }
        }
        return false;
    }
}
