package com.soi.baekjoon;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class BOJ_1015 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int len = scan.nextInt();
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            list.add(new int[]{scan.nextInt(), i});
        }
        AtomicInteger counter = new AtomicInteger(0);
        List<int[]> sortedList = list.stream()
                .sorted(Comparator.comparingInt(l -> l[0]))
                .map(i -> new int[]{i[0], counter.getAndIncrement()})
                .collect(Collectors.toList());
        ArrayList<Integer> answerList = new ArrayList<>();
        for (int[] l : list) {
            Iterator<int[]> iter = sortedList.iterator();
            while (iter.hasNext()) {
                int[] next = iter.next();
                if (next[0] == l[0]) {
                    iter.remove();
                    answerList.add(next[1]);
                    break;
                }
            }
        }
        System.out.println(answerList.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }
}
