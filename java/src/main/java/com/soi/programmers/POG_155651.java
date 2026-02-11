package com.soi.programmers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href = "https://school.programmers.co.kr/learn/courses/30/lessons/155651">호텔 대실</a>
 */
public class POG_155651 {

    public static void main(String[] args) {
        L155651 l155651 = new POG_155651();
        int solution = l155651.solution(new String[][]{{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}});
        System.out.println(solution);
    }

    public int solution(String[][] book_time) {
        Arrays.sort(book_time, Comparator.comparing((String[] book) -> book[0]));
        List<Room> rooms = new LinkedList<>();

        for (String[] time : book_time) {
            int start = Integer.parseInt(time[0].split(":")[0]) * 60 + Integer.parseInt(time[0].split(":")[1]);
            int end = Integer.parseInt(time[1].split(":")[0]) * 60 + Integer.parseInt(time[1].split(":")[1]) + 10;
            rooms.stream()
                    .filter(room -> room.end <= start)
                    .findFirst().ifPresentOrElse(
                            r -> r.occupy(start, end),
                            () -> rooms.add(new Room(start, end))
                    );
        }
        return rooms.size();
    }

    private static class Room {
        int start;
        int end;

        public Room(int start, int end) {
            this.start = start;
            this.end = end;
        }

        private void occupy(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
