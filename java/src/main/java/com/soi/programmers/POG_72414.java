package com.soi.programmers;

public class POG_72414 {
    public static void main(String[] args) {
        System.out.println(new POG_72414().solution("99:59:59", "25:00:00", new String[]{"69:59:59-89:59:59", "01:00:00-21:00:00", "79:59:59-99:59:59", "11:00:00-31:00:00"}));
    }

    public String solution(String play_time, String adv_time, String[] logs) {
        long playTime = strToNum(play_time);
        long advTime = strToNum(adv_time);
        int[] cumulativeArr = new int[(int) (playTime + 1)];
        for (String log : logs) {
            String[] startAndEntTime = log.split("-");
            long s = strToNum(startAndEntTime[0]);
            long e = strToNum(startAndEntTime[1]);
            cumulativeArr[(int) s]++;
            cumulativeArr[(int) e]--;
        }
        // 누적합 계산
        for (int i = 1; i <= playTime; i++) {
            cumulativeArr[i] += cumulativeArr[i - 1];
        }

        long maxViewTime = 0;
        long maxStartTime = 0;
        long currentViewTime = 0;

        for (int i = 0; i < advTime; i++) {
            currentViewTime += cumulativeArr[i];
        }
        maxViewTime = currentViewTime; // 초기 누적합을 구함
        for (int i = 1; i <= playTime - advTime; i++) {
            currentViewTime = currentViewTime - cumulativeArr[i - 1] + cumulativeArr[i + (int) advTime - 1];
            if (currentViewTime > maxViewTime) {
                maxViewTime = currentViewTime;
                maxStartTime = i;
            }
        }
        return numToStr(maxStartTime);
    }

    long strToNum(String input) {
        String[] timeArr = input.split(":");
        int hour = Integer.parseInt(timeArr[0]);
        int minute = Integer.parseInt(timeArr[1]);
        int second = Integer.parseInt(timeArr[2]);
        return toSecond(hour, minute, second);
    }

    String numToStr(long second) {
        int hour = (int) (second / 3600);
        second %= 3600;
        int minute = (int) (second / 60);
        second %= 60;
        int sec = (int) second;
        return String.format("%02d:%02d:%02d", hour, minute, sec);
    }

    long toSecond(int hour, int minute, int second) {
        return (long) hour * 60 * 60 + minute * 60L + second;
    }
}
