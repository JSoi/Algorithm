package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N1183 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        int minBetween = 0;
        int answer = 0;
        for (int i = 0; i < count; i++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            answer += input[1] - input[0];
            minBetween = Math.min(answer, input[1] - input[0]);
        }
        System.out.println(minBetween);
        answer += (-minBetween) * count;
        System.out.println(answer);
    }
}
