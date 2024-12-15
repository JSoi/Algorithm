package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N1246 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int eggCount = input[0];
        int pplCount = input[1];
        int[] eggBuyPriceArr = new int[pplCount];
        for (int i = 0; i < pplCount; i++) {
            eggBuyPriceArr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(eggBuyPriceArr);
        int maxSellProfit = 0;
        int maxSellPrice = 0;
        for (int s = 0; s < eggBuyPriceArr.length; s++) {
            int sellPrice = eggBuyPriceArr[s];
            int sellCount = Math.min(eggBuyPriceArr.length - s, eggCount);
            if (maxSellProfit <= sellPrice * sellCount) {
                maxSellProfit = sellPrice * sellCount;
                maxSellPrice = sellPrice;
            }
        }
        System.out.println(maxSellPrice + " " + maxSellProfit);
    }
}