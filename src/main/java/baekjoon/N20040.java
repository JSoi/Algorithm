package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * <a href = "https://www.acmicpc.net/problem/20040">사이클 게임</a>
 */
public class N20040 {
    static int[] relation;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        relation = new int[n];
        for (int r = 0; r < n; r++) {
            relation[r] = r;
        }
        int answer = 0;
        int[][] given = new int[m][2];
        for (int i = 0; i < m; i++) {
            given[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        for (int i = 0; i < m; i++) {
            int[] g = given[i];
            int parent = Math.min(g[0], g[1]);
            int child = Math.max(g[0], g[1]);
            int parentRoot = findParent(parent);
            int childRoot = findParent(child);
            if (parentRoot == childRoot) {
                answer = i + 1;
                break;
            }
            relation[childRoot] = parentRoot;
        }
        br.close();
        System.out.println(answer);
    }

    static int findParent(int target) {
        if (relation[target] == target) {
            return target;
        }
        return relation[target] = findParent(relation[target]);
    }
}
