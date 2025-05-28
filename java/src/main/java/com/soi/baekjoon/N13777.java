package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N13777 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while (!(line = buf.readLine()).equals("0")) {
            int target = Integer.parseInt(line);
            search(target);
        }
    }

    private static void search(int target) {
        int start = 1;
        int mid;
        int end = 50;
        StringBuffer buf = new StringBuffer();
        while (true) {
            mid = (start + end) / 2;
            buf.append(mid + " ");
            if (target == mid) {
                break;
            }
            if (mid < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.println(buf.toString().trim());
    }
}
