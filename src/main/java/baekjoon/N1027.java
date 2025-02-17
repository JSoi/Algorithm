package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N1027 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int buildingNum = Integer.parseInt(br.readLine());
        long[] height = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::valueOf).toArray();
        int[] answer = new int[buildingNum];
        for (int i = 0; i < buildingNum; i++) {
            double[] incline = new double[buildingNum];
            for (int before = i - 1; before >= 0; before--) {
                double inc = (double) (height[before] - height[i]) / (before - i);
                if (i - before == 1) {
                    incline[before] = inc;
                    answer[i]++;
                    continue;
                }
                if (incline[before + 1] > inc) {
                    answer[i]++;
                }
                incline[before] = Math.min(incline[before + 1], inc);
            }
            for (int after = i + 1; after < buildingNum; after++) {
                double inc = (double) (height[after] - height[i]) / (after - i);
                if (after - i == 1) {
                    incline[after] = inc;
                    answer[i]++;
                    continue;
                }
                if (incline[after - 1] < inc) {
                    answer[i]++;
                }
                incline[after] = Math.max(incline[after - 1], inc);
            }
        }
        System.out.println(Arrays.stream(answer).max().orElse(0));
    }
}
