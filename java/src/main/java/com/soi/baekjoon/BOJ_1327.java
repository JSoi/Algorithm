package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_1327 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int changeLen = Integer.parseInt(input[1]);
        String str = br.readLine().replace(" ", "");
        int answer = solve(str, changeLen);
        System.out.println(answer);
    }

    public static int solve(String input, int length) {
        HashSet<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(input);

        char[] inputArray = input.toCharArray();
        Arrays.sort(inputArray);
        String answerStr = new String(inputArray);
        int answer = -1;
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int s = 0; s < size; s++) {
                String current = queue.poll();
                if (current.equals(answerStr)) {
                    return depth;
                }
                if (visited.contains(current)) {
                    continue;
                }
                visited.add(current);
                for (int i = 0; i <= input.length() - length; i++) {
                    char[] nextArr = current.toCharArray();
                    for (int j = 0; j < (length + 1) / 2; j++) {
                        char temp = nextArr[i + j];
                        nextArr[i + j] = nextArr[i + length - j - 1];
                        nextArr[i + length - j - 1] = temp;
                    }
                    String reversed = new String(nextArr);
                    if (!visited.contains(reversed)) {
                        queue.offer(reversed);
                    }
                }
            }
            depth++;
        }
        return answer;
    }
}
