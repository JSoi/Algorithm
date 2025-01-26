package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N1679 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int givenGameNum = Integer.parseInt(br.readLine());
        int number = 1;
        int[] useNumber = new int[givenGameNum];
        StringTokenizer tok = new StringTokenizer(br.readLine(), " ");
        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < givenGameNum; i++) {
            useNumber[i] = Integer.parseInt(tok.nextToken());
        }
        useNumber = Arrays.stream(useNumber).boxed().sorted((a, b) -> b - a).mapToInt(Integer::valueOf).toArray();
        while (true) {
            if (!makeNumber(useNumber, number, 0, k)) {
                System.out.println((number % 2 == 0 ? "holsoon" : "jjaksoon") + " wins at " + number);
                return;
            }
            number++;
        }
    }

    private static boolean makeNumber(int[] useNumber, int number, int depth, int maxDepth) {
        if (number == 0) {
            return true;
        }
        if (depth >= maxDepth) {
            return false;
        }
        for (int j : useNumber) {
            if (number >= j &&
                    makeNumber(useNumber, number - j, depth + 1, maxDepth)) {
                return true;
            }
        }
        return false;
    }
}


