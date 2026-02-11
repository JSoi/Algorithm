package com.soi.baekjoon;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class BOJ_1953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ppl = Integer.parseInt(br.readLine());
        List<Integer>[] unlikeConn = new LinkedList[ppl + 1];
        for (int i = 1; i < unlikeConn.length; i++) {
            unlikeConn[i] = new LinkedList<>();
        }
        for (int l = 1; l <= ppl; l++) {
            StringTokenizer tok = new StringTokenizer(br.readLine(), " ");
            int unlikeCount = Integer.parseInt(tok.nextToken());
            while (unlikeCount-- > 0) {
                int p = Integer.parseInt(tok.nextToken());
                unlikeConn[l].add(p);
                unlikeConn[p].add(l);
            }
        }
        int[] visited = new int[ppl + 1];
        List<Integer> whiteTeam = new ArrayList<>();
        List<Integer> blackTeam = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int p = 1; p <= ppl; p++) {
            if (visited[p] != 0) {
                continue;
            }
            visited[p] = 1;
            whiteTeam.add(p);
            queue.offer(p);
            while (!queue.isEmpty()) {
                int latest = queue.poll();
                for (int u : unlikeConn[latest]) {
                    if (visited[u] != 0) continue;
                    visited[u] = visited[latest] * -1;
                    if (visited[u] == -1) {
                        blackTeam.add(u);
                    } else {
                        whiteTeam.add(u);
                    }
                    queue.offer(u);
                }
            }
        }

        Collections.sort(whiteTeam);
        Collections.sort(blackTeam);

        if (blackTeam.isEmpty()) {
            blackTeam.add(whiteTeam.remove(0));
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.append(String.valueOf(whiteTeam.size())).append("\n");
        bw.append(whiteTeam.stream().map(String::valueOf).collect(Collectors.joining(" "))).append("\n");
        bw.append(String.valueOf(blackTeam.size())).append("\n");
        bw.append(blackTeam.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        bw.flush();
    }
}
