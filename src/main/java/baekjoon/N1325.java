package baekjoon;

import java.io.*;
import java.util.*;

public class N1325 {
    static ArrayList<Integer>[] nodes;
    static boolean[] visit;
    static int[] answerArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int count = Integer.parseInt(line[1]);
        nodes = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            nodes[i] = new ArrayList<>();
        }
        for (int i = 0; i < count; i++) {
            line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            nodes[a].add(b);
        }
        br.close();
        answerArr = new int[N + 1];
        for (int start = 1; start <= N; start++) {
            Queue<Integer> bfs = new ArrayDeque<>();
            visit = new boolean[N + 1];
            bfs.offer(start);
            visit[start] = true;
            while (!bfs.isEmpty()) {
                int now = bfs.poll();
                for (int i : nodes[now]) {
                    if (!visit[i]) {
                        visit[i] = true;
                        answerArr[i]++;
                        bfs.offer(i);
                    }
                }
            }
        }
        int maxValue = -1;
        for (int i = 0; i <= N; i++) {
            maxValue = Math.max(maxValue, answerArr[i]);
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i <= N; i++) {
            if (answerArr[i] == maxValue) {
                bw.write(i + " ");
            }
        }
        bw.flush();
        bw.close();
    }
}
