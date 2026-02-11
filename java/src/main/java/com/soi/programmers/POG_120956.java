package com.soi.programmers;

import java.util.Arrays;
import java.util.Set;

public class POG_120956 {

    private static final Set<String> babble = Set.of("aya", "ye", "woo", "ma");

    public static void main(String[] args) {
        System.out.println(new POG_120956().solution(new String[]{"aya", "yee", "u", "maa", "wyeoo"}));
    }

    public int solution(String[] babbling) {
        return (int) Arrays.stream(babbling).filter(this::isBabble).count();
    }

    private boolean isBabble(String input) {
        for (String b : babble) {
            input = input.replaceFirst(b, " ");
        }
        return input.isBlank();
    }
}
