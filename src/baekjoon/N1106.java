package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N1106 {
    public static final int MAX_VALUE = 10000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tok = new StringTokenizer(br.readLine(), " ");
        int countToPopulate = Integer.parseInt(tok.nextToken());
        int candidatePopulation = countToPopulate + 100;
        int cityCount = Integer.parseInt(tok.nextToken());
        int[] costArr = new int[candidatePopulation + 1];
        Arrays.fill(costArr, MAX_VALUE);
        costArr[0] = 0;
        for (int i = 0; i < cityCount; i++) {
            tok = new StringTokenizer(br.readLine(), " ");
            int cost = Integer.parseInt(tok.nextToken());
            int population = Integer.parseInt(tok.nextToken());
            for (int p = population; p <= candidatePopulation; p++) {
                costArr[p] = Math.min(costArr[p], costArr[p - population] + cost);
            }
        }
        System.out.println(Arrays.toString(costArr));
        int answer = costArr[countToPopulate];
        for (int i = countToPopulate; i <= candidatePopulation; i++) {
            answer = Math.min(answer, costArr[i]);
        }
        System.out.println(answer);
    }
}
