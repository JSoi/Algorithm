package com.soi.programmers;

public class POG_43165 {

    static int[] numArr;
    static int fAnswer;
    static int fTarget;
    public int answer = 0;
    public int targetS = 0;

    public static void main(String[] args) {

        System.out.println(solution(new int[]{1, 1, 1, 1, 1}, 3));
    }

    public static int solution(int[] numbers, int target) {
        fAnswer = 0;
        fTarget = target;
        numArr = numbers.clone();
        solve(0, 0);
        return fAnswer;
    }

    public static void solve(int index, int value) {
        if (index == numArr.length) {
            if (fTarget == value) {
                fAnswer++;
            }
        } else {
            solve(index + 1, value - numArr[index]);
            solve(index + 1, numArr[index] + value);
        }
    }

    public int solution2(int[] numbers, int target) {
        targetS = target;
        solve(numbers, 0, 0);
        return answer;
    }

    public void solve(int[] numbers, int now, int value) { // same method name.. ^^
        if (now == numbers.length) {
            if (targetS == value) {
                answer++;
            } else {
            }
        } else {
            int vm = value - numbers[now];
            int vp = value + numbers[now];
            solve(numbers, now + 1, vm);
            solve(numbers, now + 1, vp);
        }
    }

}
