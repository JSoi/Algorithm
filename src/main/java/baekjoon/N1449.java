package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N1449 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int holeCount = Integer.parseInt(input[0]);
        int tapeLength = Integer.parseInt(input[1]);
        int tapeCount = 0;
        StringTokenizer tok = new StringTokenizer(br.readLine(), " ");
        Queue<Integer> queue = new PriorityQueue<>();
        while (tok.hasMoreTokens()) {
            queue.offer(Integer.parseInt(tok.nextToken()));
        }
        if (queue.isEmpty()) {
            throw new IllegalArgumentException();
        }
        while (!queue.isEmpty()) {
            double tapeStart = queue.peek() - 0.5;
            double tapeEnd = tapeStart + tapeLength;
            while (!queue.isEmpty() && queue.peek() <= tapeEnd) {
                queue.poll();
            }
            tapeCount++;
        }
        System.out.println(tapeCount);
    }
}
