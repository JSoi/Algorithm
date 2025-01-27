package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N1590 {
    public static final long MAX = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int busCount = input[0];
        int arrivalTime = input[1];
        long answer = MAX;
        for (int i = 0; i < busCount; i++) {
            int[] bus = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int startTime = bus[0];
            int interval = bus[1];
            int count = bus[2];
            long closestArrivalTime = getClosetArrivalTime(startTime, interval, count, arrivalTime);
            if (closestArrivalTime != MAX && closestArrivalTime >= arrivalTime) {
                answer = Math.min(answer, closestArrivalTime - arrivalTime);
            }
        }
        System.out.println(answer == MAX ? -1 : answer);
    }

    static long getClosetArrivalTime(long startTime, int interval, int count, long arrivalTime) {
        int start = 0;
        int end = count - 1;
        int mid = (start + end) / 2;
        long time = (long) mid * interval + startTime;
        if (arrivalTime > startTime + (long) interval * count) {
            return MAX;
        }
        while (start < end) {
            if (time == arrivalTime) {
                return time;
            } else if (time > arrivalTime) {
                end = mid;
            } else {
                start = mid + 1;
            }
            mid = (start + end) / 2;
            time = (long) mid * interval + startTime;
        }
        return time;
    }
}
