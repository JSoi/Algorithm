package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <a href = "https://www.acmicpc.net/problem/1301">비즈 공예</a>
 */
public class N1301 {
    static int totalBeadCount;
    static int[] beadArr;
    static int answer = 0;
    static int[] used;

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
        answer = 0;
        for (int i = 0; i < beadColorCount; i++) {
            used[i]++;
            fillBeads(1, -1, i);
            used[i]--;
        }
        System.out.println(answer);
    }

    static void fillBeads(int usedBeads, int first, int second) {
        if (usedBeads == totalBeadCount) {
            answer++;
            return;
        }
        for (int i = 0; i < beadArr.length; i++) {
            if (used[i] >= beadArr[i] || i == first || i == second) continue; // 중복된 색상
            used[i]++;
            fillBeads(usedBeads + 1, second, i);
            used[i]--;
        }
    }
}
