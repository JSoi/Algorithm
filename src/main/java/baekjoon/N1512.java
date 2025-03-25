package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class N1512 {
    private static final Map<Character, Integer> posMap = Map.of('A', 0, 'C', 1, 'G', 2, 'T', 3);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        String target = br.readLine();
        int minChange = target.length();
        for (int v = 1; v <= m; v++) {
            minChange = Math.min(minChange, changeCount(target, v));
        }
        System.out.println(minChange);
    }


    private static int changeCount(String original, int v) {
        int[][] count = new int[v][4];
        for (int j = 0; j < original.length(); j++) {
            count[j % v][posMap.get(original.charAt(j))]++;
        }
        int change = 0;
        for (int[] c : count) {
            int max = 0, sum = 0;
            for (int i = 0; i < 4; i++) {
                sum += c[i];
                max = Math.max(max, c[i]);
            }
            sum -= max;
            change += sum;
        }
        return change;
    }
}
