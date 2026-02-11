package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ_1132 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        List<Alp> arr = new ArrayList<>(); // index = char-'A'
        for (int a = 0; a < 10; a++) {
            arr.add(new Alp(a, 0, false));
        }
        for (int i = 0; i < count; i++) {
            String input = br.readLine();
            for (int j = 0; j < input.length(); j++) {
                int index = input.charAt(j) - 'A';
                if (j == 0) {
                    arr.get(index).setHead();
                }
                arr.get(index).add((long) Math.pow(10, input.length() - j - 1));
            }
        }
        arr.sort(Collections.reverseOrder());
        arr.removeIf(alp -> alp.value == 0);

        long answer = 0;
        int offset = 9;

        if (arr.size() == 10 && arr.get(9).isHead) {
            for (int i = 8; i >= 0; i--) {
                if (!arr.get(i).isHead) {
                    Alp remove = arr.remove(i);
                    arr.add(remove);
                    break;
                }
            }
        }
        for (Alp a : arr) {
            answer += offset * a.value;
            offset--;
        }
        System.out.println(answer);
    }

    private static class Alp implements Comparable<Alp> {
        int alp;
        long value;
        boolean isHead;

        public Alp(int alp, long value, boolean isHead) {
            this.alp = alp;
            this.value = value;
            this.isHead = isHead;
        }

        @Override
        public int compareTo(Alp alp) {
            return Long.compare(this.value, alp.value);
        }

        void setHead() {
            this.isHead = true;
        }

        void add(long value) {
            this.value += value;
        }
    }
}
