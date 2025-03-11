package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class N11054 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] ascDP = new int[count];
        int[] descDP = new int[count];
        Arrays.fill(ascDP, 1);
        Arrays.fill(descDP, 1);
        // asc
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < i; j++) {
                if (input[i] > input[j]) {
                    ascDP[i] = Math.max(ascDP[i], ascDP[j] + 1);
                }
            }
        }
        // desc
        for (int i = count - 1; i >= 0; i--) {
            for (int j = i + 1; j < count; j++) {
                if (input[i] > input[j]) {
                    descDP[i] = Math.max(descDP[i], descDP[j] + 1);
                }
            }
        }
        System.out.println(IntStream.range(0, count)
                .map(i -> descDP[i] + ascDP[i] - 1).max().orElse(1));
    }
}
