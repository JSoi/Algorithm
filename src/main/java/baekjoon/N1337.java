package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N1337 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int caseCount = Integer.parseInt(br.readLine());
        long[] inputArr = new long[caseCount];
        for (int i = 0; i < caseCount; i++) {
            inputArr[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(inputArr);
        int minSequence = 4;
        for (int i = 0; i < caseCount; i++) {
            int count = 4;
            long number = inputArr[i] - 1;
            int j = i - 1;
            while (number >= inputArr[i] - 4) {
                if (j >= 0 && number == inputArr[j]) {
                    j--; count--;
                }
                number--;
            }
            minSequence = Math.min(count, minSequence);
        }
        System.out.println(minSequence);
    }
}
