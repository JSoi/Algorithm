package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N1182 {
    static int answer;
    static int[] numArr;
    static boolean[] visit;
    static int targetNum;
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        targetNum = Integer.parseInt(buf.readLine().split(" ")[1]);
        numArr = Arrays.stream(buf.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        visit = new boolean[numArr.length];
        answer = 0;
        travel(0, 0);
        System.out.println(answer);
    }

    private static void travel(int index, int sum) {
        if(sum == targetNum && hasLeast()){
            answer++;
        }
        for (int i = index; i < numArr.length; i++) {
            if(!visit[i]){
                visit[i] = true;
                travel(i, sum + numArr[i]);
                visit[i] = false;
            }
        }
    }

    private static boolean hasLeast() {
        for (boolean b : visit) {
            if(b) return true;
        }
        return false;
    }
}
