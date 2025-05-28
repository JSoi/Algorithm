package com.soi.programmers;

import java.util.Arrays;
import java.util.Comparator;

public class L250121 {
    public static void main(String[] args) {
        int[][] data = new int[][]{{1, 20300104, 100, 80}, {2, 20300804, 847, 37}, {3, 20300401, 10, 8}};
        int[][] solution = new L250121().solution(data, "date", 20300521, "remain");
        Arrays.stream(solution).forEach(a -> System.out.println(Arrays.toString(a)));
    }

    public int[][] solution(int[][] data, String ext, int extVal, String sort) {
        return Arrays.stream(data).map(d -> new Data(d[0], d[1], d[2], d[3]))
                .filter(d -> d.getQuantity(DataType.valueOf(ext)) < extVal)
                .sorted(Comparator.comparingInt(d -> d.getQuantity(DataType.valueOf(sort))))
                .map(Data::toArray).toArray(int[][]::new);
    }

    static class Data {
        int code;
        int date;
        int maximum;
        int remain;

        public Data(int code, int date, int maximum, int remain) {
            this.code = code;
            this.date = date;
            this.maximum = maximum;
            this.remain = remain;
        }

        int getQuantity(DataType type) {
            return switch (type) {
                case code -> this.code;
                case date -> this.date;
                case maximum -> this.maximum;
                case remain -> this.remain;
            };
        }

        int[] toArray() {
            return new int[]{this.code, this.date, this.maximum, this.remain};
        }
    }

    enum DataType {
        code, date, maximum, remain;
    }
}
