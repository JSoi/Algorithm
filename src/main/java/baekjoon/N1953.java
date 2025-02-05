package baekjoon;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class N1953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ppl = Integer.parseInt(br.readLine());
        Set<Integer>[] unlikeConn = new Set[ppl + 1];
        for (int i = 0; i < unlikeConn.length; i++) {
            unlikeConn[i] = new HashSet<>();
        }
        for (int l = 1; l <= ppl; l++) {
            StringTokenizer tok = new StringTokenizer(br.readLine(), " ");
            int unlikeCount = Integer.parseInt(tok.nextToken());
            if (unlikeCount == 0) {
                continue;
            }
            int p = Integer.parseInt(tok.nextToken());
            unlikeConn[l].add(p);
            unlikeConn[p].add(l);
        }
        int[] visited = new int[ppl + 1];
        Queue<Integer> queue = new LinkedList<>();
        for (int p = 1; p <= ppl; p++) {
            if (visited[p] != 0) {
                continue;
            }
            visited[p] = 1;
            queue.offer(p);
            while (!queue.isEmpty()) {
                int latest = queue.poll();
                for (int i = 1; i <= ppl; i++) {
                    if (visited[i] != 0) continue;
                    if (unlikeConn[latest].contains(i)) {
                        visited[i] = visited[latest] * -1;
                    }
                }
            }
        }

        int[] blackTeam = IntStream.rangeClosed(1, ppl).filter(p -> visited[p] == 1).toArray();
        int[] whiteTeam = IntStream.rangeClosed(1, ppl).filter(p -> visited[p] == -1).toArray();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.append(String.valueOf(blackTeam.length)).append("\n");
        bw.append(Arrays.stream(blackTeam).mapToObj(String::valueOf).collect(Collectors.joining(" "))).append("\n");
        bw.append(String.valueOf(whiteTeam.length)).append("\n");
        bw.append(Arrays.stream(whiteTeam).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
        bw.flush();
    }
}
