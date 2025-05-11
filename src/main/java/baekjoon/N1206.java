package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N1206 {
    static double[] averageArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        averageArr = new double[n];
        for (int i = 0; i < n; i++) {
            averageArr[i] = Double.parseDouble(br.readLine());
        }
        int answer = 1;
        while (true) {
            if (isParticipantCount(answer)) {
                System.out.println(answer);
                return;
            }
            answer++;
        }
    }

    private static boolean isParticipantCount(int ppl) {
        for (double a : averageArr) {
            if (!isBetween(a, ppl)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isBetween(double avg, int ppl) {
        // sum
        double totalSum = avg * ppl;
        if (totalSum > ppl * 10) {
            return false;
        }
        for (int i = (int) totalSum; i <= (int) Math.ceil(avg) * ppl; i++) {
            if (Double.compare(getAverageWithThreeDigits(i, ppl), avg) == 0) {
                return true;
            }
        }
        return false;
    }

    private static double getAverageWithThreeDigits(int sum, int n) {
        return Math.floor((double) sum / n * 1000) / 1000;
    }
}
