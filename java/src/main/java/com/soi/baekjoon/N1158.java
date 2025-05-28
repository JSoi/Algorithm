package com.soi.baekjoon;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class N1158 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int removeIdx = 0;
        ArrayList<Integer> list = IntStream.rangeClosed(1, N).boxed().collect(Collectors.toCollection(ArrayList::new));
        ArrayList<Integer> answerList = new ArrayList<>();
        for (int count = N; count >= 1; count--) {
            removeIdx = (removeIdx + K - 1) % list.size();
            answerList.add(list.get(removeIdx));
            list.remove(removeIdx);
        }
        String answer = answerList.stream().map(String::valueOf).collect(Collectors.joining(", ", "<", ">"));
        System.out.println(answer);
    }
}
