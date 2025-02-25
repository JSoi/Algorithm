package baekjoon;

import java.util.Scanner;
import java.util.Set;

public class N1344 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextInt() / 100.0;
        double b = scanner.nextInt() / 100.0;
        double[][] aPercent = new double[19][19];
        double[][] bPercent = new double[19][19];

        aPercent[0][0] = 1.0;
        bPercent[0][0] = 1.0;

        for (int t = 1; t <= 18; t++) {
            for (int s = t; s > 0; s--) {
                aPercent[t][s] = aPercent[t - 1][s - 1] * a
                        + aPercent[t - 1][s] * (1 - a);
                bPercent[t][s] = bPercent[t - 1][s - 1] * b
                        + bPercent[t - 1][s] * (1 - b);
            }
            aPercent[t][0] = aPercent[t - 1][0] * (1 - a);
            bPercent[t][0] = bPercent[t - 1][0] * (1 - b);
        }

        Set<Integer> primeNums = Set.of(2, 3, 5, 7, 11, 13, 17);
        double aPrime = 0.0;
        double bPrime = 0.0;

        for (int t : primeNums) {
            aPrime += aPercent[18][t];
            bPrime += bPercent[18][t];
        }
        double result = 1 - (1 - aPrime) * (1 - bPrime);
        System.out.println( result);
    }
}
