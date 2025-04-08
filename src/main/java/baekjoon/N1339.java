package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N1339 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int caseCount = Integer.parseInt(br.readLine());
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < caseCount; i++) {
            String line = br.readLine();
            char[] lineArr = line.toCharArray();
            for (int j = 0; j < lineArr.length; j++) {
                char target = lineArr[j];
                int value = line.length() - j - 1;
                map.put(target, map.getOrDefault(target, 0) + (int) Math.pow(10, value));
            }
        }
        int offset = 9;
        int answer = 0;
        List<Integer> weights = new ArrayList<>(map.values());
        weights.sort(Collections.reverseOrder());
        for (int w : weights) {
            answer += w * offset--;
        }
        System.out.println(answer);
    }
}
