package com.soi.programmers;

public class L150367 {
    public static void main(String[] args) {
        solution(new long[]{7, 47, 5});
    }

    public static int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        for (int i = 0; i < answer.length; i++) {
            int height = height(numbers[i]);
            int count = (int) Math.pow(2, height) - 1;
            String strNum = toBinaryString(numbers[i], count);
            answer[i] = buildTree(strNum) ? 1 : 0;
        }
        return answer;
    }

    // 트리 높이 h에 따른 원소 수 : 2^n - 1 개로 표현 가능한 이진
    private static int height(long input) {
        long result = 1;
        int h = 1;
        while (result < input) {
            h++;
            int count = (int) Math.pow(2, h) - 1;
            result = (long) Math.pow(2, count) - 1;
        }
        return h;
    }

    private static boolean buildTree(String input) {
        if (input.length() == 1) {
            return true;
        }
        if (input.length() == 3) {
            return input.charAt(1) == '1' || input.equals("000");
        }

        int mid = input.length() / 2;
        String left = input.substring(0, mid);
        String right = input.substring(mid + 1);

        if (buildTree(left) && buildTree(right)) {
            if (left.contains("1") || right.contains("1")) {
                return input.charAt(mid) == '1';
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    private static String toBinaryString(long num, int len) {
        StringBuilder sb = new StringBuilder();
        sb.append(Long.toBinaryString(num));
        while (sb.length() < len) {
            sb.insert(0, "0");
        }
        return sb.toString();
    }
}
