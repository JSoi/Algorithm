package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * <a href = "https://www.acmicpc.net/problem/1263">시간 관리</a>
 */
public class N1263 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] works = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            works[i][0] = Integer.parseInt(line[0]);
            works[i][1] = Integer.parseInt(line[1]);
        }
        Arrays.sort(works, (a, b) -> Math.toIntExact(a[1] == b[1] ? b[0] - a[0] : b[1] - a[1]));
        // 끝나는 시간 내림차순, 걸리는 시간 내림차순
        int latestStartTime = Integer.MAX_VALUE;
        for (int[] w : works) {
            if (latestStartTime > w[1]) {
                latestStartTime = w[1] - w[0];
            } else {
                latestStartTime -= w[0];
            }
            if (latestStartTime < 0) {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(latestStartTime);
    }
}
