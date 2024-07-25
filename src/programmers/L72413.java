package programmers;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class L72413 {
    public static void main(String[] args) {
        int solution = new L72413().solution(6, 4, 6, 2, new int[][]{{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}});
        System.out.println(solution);

    }


    public int solution(int n, int s, int a, int b, int[][] fares) {
        int[][] distances = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(distances[i], Integer.MAX_VALUE);
        }

        for (int[] fare : fares) {
            distances[fare[0] - 1][fare[1] - 1] = distances[fare[1] - 1][fare[0] - 1] = fare[2];
        }

        // Floyd-Warshall algorithm
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (distances[i][k] == Integer.MAX_VALUE || distances[k][j] == Integer.MAX_VALUE) {
                        continue;
                    }
                    distances[i][j] = i == j ? 0 : Math.min(distances[i][j], distances[i][k] + distances[k][j]);
                }
            }
        }

        // Calculate minimum fare
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (distances[s - 1][i] == Integer.MAX_VALUE || distances[i][a - 1] == Integer.MAX_VALUE || distances[i][b - 1] == Integer.MAX_VALUE) {
                continue;
            }
            answer = Math.min(answer, distances[s - 1][i] + distances[i][a - 1] + distances[i][b - 1]);
        }
        return answer;
    }
}
