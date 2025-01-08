package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N1495 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tok = new StringTokenizer(br.readLine(), " ");
        int volumeCount = Integer.parseInt(tok.nextToken());
        int startVolume = Integer.parseInt(tok.nextToken());
        int maxVolume = Integer.parseInt(tok.nextToken());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        List<Integer>[] lists = new ArrayList[volumeCount + 1];
        lists[0] = List.of(startVolume);
        for (int i = 1; i < lists.length; i++) {
            lists[i] = new ArrayList<>();
            for (int v : lists[i - 1]) {
                if (v + arr[i - 1] <= maxVolume) {
                    lists[i].add(v + arr[i - 1]);
                }
                if (v - arr[i - 1] >= 0) {
                    lists[i].add(v - arr[i - 1]);
                }
            }
        }
        System.out.println(lists[lists.length - 1].stream().mapToInt(Integer::valueOf).max().orElse(-1));
    }
}
