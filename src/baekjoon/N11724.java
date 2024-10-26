package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class N11724 {
    static boolean[] vertexVisit;
    static boolean[][] conn;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] countLine = br.readLine().split(" ");
        int vertex = Integer.parseInt(countLine[0]);
        int edge = Integer.parseInt(countLine[1]);
        conn = new boolean[vertex][vertex];
        vertexVisit = new boolean[vertex];
        for (int l = 0; l < edge; l++) {
            String[] line = br.readLine().split(" ");
            int from = Integer.parseInt(line[0]) - 1;
            int to = Integer.parseInt(line[1]) - 1;
            conn[from][to] = conn[to][from] = true;
        }

        int totalConnection = 0;
        for (int v = 0; v < vertex; v++) {
            if (vertexVisit[v]) {
                continue;
            }
            totalConnection++;
            dfs(v);
        }

        System.out.println(totalConnection);
    }

    private static void dfs(int v) {
        Stack<Integer> dfs = new Stack<>();
        dfs.push(v);
        while (!dfs.isEmpty()) {
            int latest = dfs.pop();
            for (int i = 0; i < vertexVisit.length; i++) {
                if (!conn[latest][i] || vertexVisit[i]) {
                    continue;
                }
                vertexVisit[i] = true;
                conn[latest][i] = conn[i][latest] = false;
                dfs.push(i);
            }
        }
    }
}
