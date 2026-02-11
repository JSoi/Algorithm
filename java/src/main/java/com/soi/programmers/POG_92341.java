package com.soi.programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class POG_92341 {
    public static void main(String[] args) {
        int[] solution = new POG_92341().solution(new int[]{180, 5000, 10, 600}, new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"});
        System.out.println(Arrays.toString(solution));

    }

    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> parkingInfo = new HashMap<>();
        Map<String, Integer> parkingFee = new HashMap<>();
        Fee fee = new Fee(fees[0], fees[1], fees[2], fees[3]);
        for (String r : records) {
            String[] values = r.split(" ");
            int hour = Integer.parseInt(values[0].split(":")[0]);
            int minute = Integer.parseInt(values[0].split(":")[1]);
            String carNumber = values[1];
            boolean enter = values[2].equals("IN");
            if (!enter) { // out
                parkingFee.put(carNumber, parkingFee.getOrDefault(carNumber, 0) + parkingInfo.get(carNumber) + time(hour, minute));
                parkingInfo.remove(carNumber);
            } else {
                parkingInfo.put(carNumber, -time(hour, minute));
            }
        }

        for (Map.Entry<String, Integer> left : parkingInfo.entrySet()) {
            parkingFee.put(left.getKey(), parkingFee.getOrDefault(left.getKey(), 0) + left.getValue() + time(23, 59));
        }
        return parkingFee.entrySet().stream().sorted(Map.Entry.comparingByKey())
                .map(a -> fee.totalFeeForMinute(a.getValue())).mapToInt(Integer::intValue).toArray();
    }

    private int time(int hour, int minute) {
        return hour * 60 + minute;
    }

    static class Fee {
        int baseTime, baseFee, perTime, perFee;

        public Fee(int baseTime, int baseFee, int perTime, int perFee) {
            this.baseTime = baseTime;
            this.baseFee = baseFee;
            this.perTime = perTime;
            this.perFee = perFee;
        }

        public int totalFeeForMinute(int totalMinute) {
            if (totalMinute < baseTime) {
                return baseFee;
            }
            return baseFee + (int) Math.ceil((double) (totalMinute - baseTime) / perTime) * perFee;
        }
    }
}
