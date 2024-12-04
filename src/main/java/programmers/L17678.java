package programmers;

import java.util.*;
import java.util.stream.Collectors;

public class L17678 {
    public static void main(String[] args) {
//        String solution = new L17678().solution(1, 1, 5, new String[]{"08:00", "08:01", "08:02", "08:03"});
        String solution = new L17678().solution(2, 10, 2, new String[]{"09:10", "09:09", "08:00"});
        System.out.println("solution = " + solution);
    }

    public String solution(int n, int t, int m, String[] timetable) {
        Queue<Shuttle> shuttles = new LinkedList<>();
        Queue<Integer> crews = new LinkedList<>(Arrays.stream(timetable).map(this::toMinute).sorted().collect(Collectors.toList()));

        int arrivalTime = 540;
        while (n > 0) {
            shuttles.offer(new Shuttle(arrivalTime, m));
            n--;
            arrivalTime += t;
        }
        while (!shuttles.isEmpty()) {
            Shuttle arrivedShuttle = shuttles.peek();
            while (!arrivedShuttle.isFull() && !crews.isEmpty() && arrivedShuttle.arrivalTime >= crews.peek()) {
                arrivedShuttle.onBoard(crews.poll());
            }
            if (arrivedShuttle.isFull() || crews.isEmpty() || arrivedShuttle.arrivalTime < crews.peek()) {
                shuttles.poll();
            }
            if (shuttles.isEmpty() || arrivedShuttle.arrivalTime + t >= 1440) {
                int latestTime = getLatestTime(arrivedShuttle);
                return toTimeStr(latestTime);
            }
        }
        return "";
    }

    public int getLatestTime(Shuttle shuttle) {
        if (shuttle.customers.isEmpty()) {
            return shuttle.arrivalTime;
        }
        if (shuttle.isFull()) {
            return shuttle.customers.get(shuttle.capacity - 1) - 1;
        }
        return shuttle.arrivalTime;
    }

    private static class Shuttle {
        List<Integer> customers;
        int capacity;
        int arrivalTime;

        public Shuttle(int arrivalTime, int capacity) {
            this.arrivalTime = arrivalTime;
            this.capacity = capacity;
            this.customers = new ArrayList<>();
        }

        public void onBoard(int customer) {
            if (this.customers.size() <= capacity) {
                this.customers.add(customer);
            } else {
                throw new IndexOutOfBoundsException();
            }
        }

        public boolean isFull() {
            return customers.size() == this.capacity;
        }
    }

    private int toMinute(String timeStr) {
        int[] time = Arrays.stream(timeStr.split(":"))
                .mapToInt(Integer::parseInt).toArray();
        return time[0] * 60 + time[1];
    }

    private String toTimeStr(int time) {
        return String.format("%02d:%02d", time / 60, time % 60);
    }
}
