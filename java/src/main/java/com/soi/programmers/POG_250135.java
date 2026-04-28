package com.soi.programmers;

import com.soi.tool.Assertions;

public class POG_250135 {
    public static void main(String[] args) throws Exception {
        Assertions.check(new POG_250135().solution(12, 0, 0, 12, 0, 30), 1);
    }

    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        Time start = new Time(h1, m1, s1);
        Time end = new Time(h2, m2, s2);
        int answer = end.alarmCount - start.alarmCount;
        if (start.isTwelve()) {
            answer++;
        }
        return answer;
    }

    static class Time {
        long hour;
        long minute;
        long second;
        long totalSecond;
        int alarmCount;

        public Time(int hour, int minute, int second) {
            this.hour = hour;
            this.minute = minute;
            this.second = second;
            totalSecond = timeToSecond(hour, minute, second);
            int secondMinuteAlarm = (int) ((totalSecond * 59) / 3600);
            int secondHourAlarm = (int) ((totalSecond * 719) / 43200);
            int secondMinuteHourAlarm = (int) (totalSecond / 43200);
            alarmCount = secondHourAlarm + secondMinuteAlarm - secondMinuteHourAlarm;
        }

        public boolean isTwelve() {
            return (totalSecond * 59) % 3600 == 0 || (totalSecond * 719) % 43200 == 0;
        }

        private long timeToSecond(int h, int m, int s) {
            return h * 3600L + m * 60L + s;
        }
    }
}
