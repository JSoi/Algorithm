package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * <a href = "https://www.acmicpc.net/problem/1301">비즈 공예</a>
 */
public class N1301 {
    static int totalBeadCount;
    static int[] beadArr;
    static int[] used;
    static Map<String, Integer> beadMap = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int beadColorCount = Integer.parseInt(br.readLine()); // [3,5]
        totalBeadCount = 0;
        beadArr = new int[beadColorCount];
        used = new int[beadColorCount];
        for (int b = 0; b < beadColorCount; b++) {
            int count = Integer.parseInt(br.readLine());
            beadArr[b] = count;
            totalBeadCount += count;
        }
        int answer = 0;
        for (int i = 0; i < beadColorCount; i++) {
            used[i]++;
            answer += fillBeads(1, "", -1, i);
            used[i]--;
        }
        System.out.println(answer);
    }

    static int fillBeads(int usedBeads, String status, int last1, int last2) {
        if (usedBeads == totalBeadCount) return 1;
        String key = status + (last1 == -1 ? "" : String.valueOf(last1)) + last2;
        if (beadMap.containsKey(key)) return beadMap.get(key);
        int total = 0;
        for (int i = 0; i < beadArr.length; i++) {
            if (used[i] >= beadArr[i] || i == last1 || i == last2) continue;
            used[i]++;
            total += fillBeads(usedBeads + 1, status + "" + i, last2, i);
            used[i]--;
        }
        beadMap.put(key, total);
        return total;
    }
}
