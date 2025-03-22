package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N20040 {
    static int[] relation;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        relation = new int[n];
        Arrays.fill(relation, -1);
        int answer = 0;
        for (int i = 0; i < m; i++) {
            String[] line = br.readLine().split(" ");
            int parent = Math.min(Integer.parseInt(line[0]), Integer.parseInt(line[1]));
            int child = Math.max(Integer.parseInt(line[0]), Integer.parseInt(line[1]));
            if (relation[child] != -1) {
                answer = i+1;
                break;
            }
            relation[child] = findParent(parent);
        }
        br.close();
        System.out.println(answer);
    }

    static int findParent(int target) {
        if (relation[target] == -1) {
            return target;
        }
        return findParent(relation[target]);
    }
}
