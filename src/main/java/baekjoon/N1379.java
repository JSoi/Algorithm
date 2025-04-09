package baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class N1379 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int lectureCount = Integer.parseInt(br.readLine());
        Queue<int[]> roomQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        int[] answer = new int[lectureCount];
        ArrayList<int[]> lectures = new ArrayList<>();
        for (int l = 0; l < lectureCount; l++) {
            String[] line = br.readLine().split(" ");
            int lectureNo = Integer.parseInt(line[0]) - 1;
            int lectureStartTime = Integer.parseInt(line[1]);
            int lectureEndTime = Integer.parseInt(line[2]);
            lectures.add(new int[]{lectureNo, lectureStartTime, lectureEndTime});
        }
        lectures.sort(Comparator.comparingInt(a -> a[1]));
        int totalRoomCount = 0;
        for (int[] lecture : lectures) {
            if (!roomQueue.isEmpty() && roomQueue.peek()[1] <= lecture[1]) {
                int[] availableRoom = roomQueue.poll();
                roomQueue.offer(new int[]{availableRoom[0], lecture[2]});
                answer[lecture[0]] = availableRoom[0];
            } else {
                roomQueue.offer(new int[]{totalRoomCount, lecture[2]});
                answer[lecture[0]] = totalRoomCount;
                totalRoomCount++;
            }
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.append(String.valueOf(totalRoomCount)).append("\n");
        for (int a : answer) {
            bw.append(String.valueOf(a + 1)).append("\n");
        }
        bw.flush();

    }
}
