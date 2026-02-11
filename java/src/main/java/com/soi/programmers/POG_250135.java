package com.soi.programmers;

import com.soi.tool.Assertions;

public class POG_250135 {
    public static void main(String[] args) throws Exception {
        Assertions.check(new POG_250135().solution(0, 5, 30, 0, 7, 0), 2);
        Assertions.check(new POG_250135().solution(12, 0, 0, 12, 0, 30), 1);
        Assertions.check(new POG_250135().solution(0, 6, 1, 0, 6, 6), 0);
        Assertions.check(new POG_250135().solution(11, 59, 30, 12, 0, 0), 0);
        Assertions.check(new POG_250135().solution(11, 58, 59, 11, 59, 0), 1);
        Assertions.check(new POG_250135().solution(1, 5, 5, 1, 5, 6), 2);
        Assertions.check(new POG_250135().solution(0, 0, 0, 23, 59, 59), 2852);

    }

    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        Time time1 = new Time(h1, m1, s1);
        Time time2 = new Time(h2, m2, s2);
        return 0;
    }

    static class Time {
        int hour;
        int minute;
        int second;

        double hourAngle;
        double minuteAngle;
        double secondAngle;

        public Time(int hour, int minute, int second) {
            this.hour = hour;
            this.minute = minute;
            this.second = second;
            this.hourAngle = this.hourAngle();
            this.minuteAngle = this.minuteAngle();
            this.secondAngle = this.secondAngle();
//            this.print();
        }

        protected int timeFormatToSecond() {
            return hour * 3600 + minute * 60 + second;
        }

        @Override
        public String toString() {
            return "Time{" +
                    "hour=" + hour +
                    ", minute=" + minute +
                    ", second=" + second +
                    ", hourAngle=" + hourAngle +
                    ", minuteAngle=" + minuteAngle +
                    ", secondAngle=" + secondAngle +
                    '}';
        }

        // 온전히 한 바퀴를 돈 차이를 담은 time class 리턴
        public Time timeDiff(Time compare) {
            Time greater = this.timeFormatToSecond() >= compare.timeFormatToSecond() ? this : compare;
            Time less = this.timeFormatToSecond() < compare.timeFormatToSecond() ? this : compare;

            int hourDiff, minuteDiff, secondDiff;

            hourDiff = greater.hour - less.hour;
            minuteDiff = greater.minute - less.minute;
            secondDiff = greater.second - less.second;

            minuteDiff -= (secondDiff >= 0 ? 0 : 1);
            hourDiff -= minuteDiff >= 0 ? 0 : 1;
            minuteDiff = minuteDiff < 0 ? minuteDiff + 60 : minuteDiff;
            secondDiff = secondDiff < 0 ? secondDiff + 60 : secondDiff;

            return new Time(hourDiff, minuteDiff, secondDiff);
        }

        protected double hourAngle() {
            return (this.hour % 12) * 30 + 0.5 * minute + (0.5 / 60) * minute;
        }

        protected double minuteAngle() {
            return 6 * minute + 0.1 * second;
        }

        protected double secondAngle() {
            return 6 * second;
        }

        public void print() {

            System.out.println(this.hourAngle);
            System.out.println(this.minuteAngle);
            System.out.println(this.secondAngle);
            System.out.println("----");
        }
    }
}
