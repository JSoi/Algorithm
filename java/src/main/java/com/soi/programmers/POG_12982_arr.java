package com.soi.programmers;

import java.util.Arrays;

public class POG_12982_arr {
    public static void main(String[] args) {

        System.out.println(solution(new int[]{1, 3, 2, 5, 4}, 9));
    }

    public static int solution(int[] d, int budget) {
        Arrays.sort(d);
        int i = 0;
        int hap = 0;
        for (i = 0; i < d.length; i++) {
            hap += d[i];
            if (hap > budget) {
                break;
            }
        }
        return i;

        /**
         * if (d.length == 1) { if (d[0] > budget) return 0; else return 1; } if(d[0] >
         * budget) return 0; for (i = 0; i < d.length - 1; i++) { hap += d[i]; if (hap +
         * d[i + 1] > budget) { break; } // }
         */
    }
}
