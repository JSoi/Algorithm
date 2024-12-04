package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class N1107 {
    static boolean[] normal;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int target = scan.nextInt();
        int count = scan.nextInt();
        normal = new boolean[10];
        Arrays.fill(normal, true);
        for (int c = 0; c < count; c++) {
            normal[scan.nextInt()] = false;
        }
        int answer = Math.abs(target - 100);
        for (int i = 0; i < 1000000; i++) {
            if (isPushable(i)) {
                answer = Math.min(answer, String.valueOf(i).length() + Math.abs(i - target));
            } else {
                answer = Math.min(Math.abs(target - 100), answer);
            }
        }
        System.out.println(answer);
    }

    static boolean isPushable(int target) {
        String targetToStr = String.valueOf(target);
        for (int i = 0; i < targetToStr.length(); i++) {
            if (!normal[targetToStr.charAt(i) - '0']) {
                return false;
            }
        }
        return true;
    }
}
