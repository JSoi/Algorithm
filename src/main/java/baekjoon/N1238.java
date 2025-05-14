package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N1238 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int X = Integer.parseInt(input[2]);
        int[][] distance = new int[N][N];
        for (int[] c : distance) {
            Arrays.fill(c, Integer.MAX_VALUE);
        }
        distance[X - 1][X - 1] = 0;

        for (int i = 0; i < M; i++) {
            String[] c = br.readLine().split(" ");
            int a = Integer.parseInt(c[0]) - 1;
            int b = Integer.parseInt(c[1]) - 1;
            int dist = Integer.parseInt(c[2]);
            distance[a][b] = dist;
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (distance[i][k] == Integer.MAX_VALUE || distance[k][j] == Integer.MAX_VALUE) {
                        continue;
                    }
                    distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < N; i++) {
            ans = Math.max(ans, distance[i][X - 1] + distance[X - 1][i]);
        }
        System.out.println(ans);
    }
}
