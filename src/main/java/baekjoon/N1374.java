package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class N1374 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int classCount = Integer.parseInt(br.readLine());
        long[][] classArr = new long[classCount][2];
        for (int c = 0; c < classCount; c++) {
            long[] inputLine = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
            classArr[c][0] = inputLine[1];
            classArr[c][1] = inputLine[2];
        }
        Arrays.sort(classArr, Comparator.comparingLong(a -> a[0]));
        PriorityQueue<Long> endTimeQueue = new PriorityQueue<>();
        for (long[] c : classArr) {
            if (!endTimeQueue.isEmpty() && endTimeQueue.peek() <= c[0]) {
                endTimeQueue.poll();
            }
            endTimeQueue.offer(c[1]);
        }
        System.out.println(endTimeQueue.size());
    }
}
