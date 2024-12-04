package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N1202 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
        int jewelCount = Integer.parseInt(tokenizer.nextToken());
        int bagCount = Integer.parseInt(tokenizer.nextToken());
        Jewel[] jewels = new Jewel[jewelCount];
        int[] bags = new int[bagCount];
        for (int j = 0; j < jewelCount; j++) {
            tokenizer = new StringTokenizer(br.readLine(), " ");
            int weight = Integer.parseInt(tokenizer.nextToken());
            int price = Integer.parseInt(tokenizer.nextToken());
            jewels[j] = new Jewel(price, weight);
        }
        long totalPrice = 0;
        for (int b = 0; b < bagCount; b++) {
            bags[b] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(bags);
        Arrays.sort(jewels);
        PriorityQueue<Integer> usedJewelPriceQueue
                = new PriorityQueue<>(Comparator.reverseOrder());
        int jewelIndex = 0;
        for (int bagIndex = 0; bagIndex < bagCount; bagIndex++) {
            while (jewelIndex < jewelCount && jewels[jewelIndex].weight <= bags[bagIndex]) {
                usedJewelPriceQueue.add(jewels[jewelIndex++].price);
            }
            if (!usedJewelPriceQueue.isEmpty()) {
                totalPrice += usedJewelPriceQueue.poll();
            }
        }
        System.out.println(totalPrice);
    }

    static class Jewel implements Comparable<Jewel> {
        int price;
        int weight;

        public Jewel(int price, int weight) {
            this.price = price;
            this.weight = weight;
        }

        @Override
        public int compareTo(Jewel other) {
            return this.weight == other.weight ? other.price - this.price : this.weight - other.weight;
        }
    }
}
