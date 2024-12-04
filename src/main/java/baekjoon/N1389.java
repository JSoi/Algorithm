package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N1389 {
    static int[] kevinCount;
    static Map<Integer, Set<Integer>> connMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] countArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        int pplCount = countArr[0];
        int connCount = countArr[1];
        connMap = new HashMap<>();
        for (int m = 0; m < pplCount; m++) {
            connMap.put(m, new HashSet<>());
        }
        while (connCount-- > 0) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
            int from = input[0] - 1, to = input[1] - 1;
            connMap.get(from).add(to);
            connMap.get(to).add(from);
        }
        int min = Integer.MAX_VALUE;
        int answer = -1;
        for (int f = 0; f < pplCount; f++) {
            kevinCount = new int[pplCount];
            Arrays.fill(kevinCount, -1);
            travel(f);
            int kc = Arrays.stream(kevinCount).sum();
            if (min > kc) {
                min = kc;
                answer = f + 1;
            }
        }
        System.out.println(answer);
    }

    static void travel(int from) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(from);
        kevinCount[from] = 0;
        while (!queue.isEmpty()) {
            int latest = queue.poll();
            for (int acc : connMap.get(latest)) {
                if (kevinCount[acc] > 0) {
                    continue;
                }
                kevinCount[acc] = kevinCount[latest] + 1;
                queue.offer(acc);
            }
        }
    }
}
