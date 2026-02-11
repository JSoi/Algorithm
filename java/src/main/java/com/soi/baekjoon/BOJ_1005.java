package com.soi.baekjoon;

import java.io.*;

public class BOJ_1005 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = Integer.parseInt(br.readLine());
        for (int i = 0; i < count; i++) {
            String line = br.readLine();
            int N = Integer.parseInt(line.split(" ")[0]);
            int K = Integer.parseInt(line.split(" ")[1]);
            String timeLine = br.readLine();
            int[] time = new int[N];
            boolean[][] conn = new boolean[N][N];
            for (int j = 0; j < N; j++) {
                time[j] = Integer.parseInt(timeLine.split(" ")[j]);
            }
            for (int k = 0; k < K; k++) {
                String mLine = br.readLine();
                conn[Integer.parseInt(mLine.split(" ")[0]) - 1][Integer.parseInt(mLine.split(" ")[1]) - 1] = true;
            }
            F1005 myc = new F1005(N, K, conn, time);
            int goal = Integer.parseInt(br.readLine());
            myc.process(goal - 1);
            bw.append(myc.answer(goal) + "\n");
        }
        bw.flush();
    }

    static class F1005 {
        int N, K;
        int[] time;
        boolean[] visit;
        boolean[][] conn;

        public F1005(int N, int K, boolean[][] conn, int[] time) {
            this.N = N;
            this.K = K;
            this.conn = conn;
            this.time = time;
            visit = new boolean[N];
        }

        public void process(int input) {
            int max = 0;
            for (int j = 0; j < N; j++) {
                if (conn[j][input]) {
                    if (!visit[j]) {
                        process(j);
                    }
                    max = Math.max(max, time[j]);
                }
            }
            time[input] += max;
            visit[input] = true;
        }

        public String answer(int goal) {
            return time[goal - 1] + "";
        }
    }
}

