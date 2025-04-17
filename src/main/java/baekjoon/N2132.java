package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * <a href = "https://www.acmicpc.net/problem/2132">나무위의 벌레</a>
 */
public class N2132 {
    static int[] fruitStatus;
    static int maxFruitCount;
    static int vertex;
    static List<Integer>[] conn;
    static int maxFruit;
    static int farthestNode;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        maxFruitCount = Integer.parseInt(br.readLine());
        fruitStatus = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        vertex = fruitStatus.length;
        conn = new List[vertex];
        for (int i = 0; i < conn.length; i++) {
            conn[i] = new ArrayList<>();
        }
        for (int i = 0; i < vertex - 1; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]) - 1;
            int b = Integer.parseInt(input[1]) - 1;
            conn[a].add(b);
            conn[b].add(a);
        }

        farthestNode = 0;
        maxFruit = 0;

        dfs(0, -1, fruitStatus[0]);
        int bestStart = farthestNode;
        dfs(farthestNode, -1, fruitStatus[farthestNode]);

        System.out.println(String.format("%d %d", maxFruit,  Math.min(bestStart,farthestNode)+ 1));

    }

    static void dfs(int node, int parent, int acc) {
        if (acc >= maxFruit) {
            maxFruit = acc;
            farthestNode = node;
        }

        for (int next : conn[node]) {
            if (next != parent) {
                dfs(next, node, acc + fruitStatus[next]);
            }
        }
    }
}
