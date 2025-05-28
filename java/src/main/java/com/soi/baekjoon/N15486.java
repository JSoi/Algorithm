package com.soi.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class N15486 {
    static int[] time, money, dp;
    static int cnt, answer;

    public static void main(String[] args) throws IOException {
        input();
        top_bottom();
//        bottom_up();
        System.out.println(answer);
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        cnt = Integer.parseInt(br.readLine());
        time = new int[cnt + 1];
        money = new int[cnt + 1];
        dp = new int[cnt + 1];
        for (int i = 0; i < cnt; i++) {
            StringTokenizer tok = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(tok.nextToken());
            money[i] = Integer.parseInt(tok.nextToken());
        }
    }

    static void top_bottom() {
        answer = 0;
        //cnt 부터 시작해주어야 한다^^ (마지막 날에 시간이 1 필요한 작업의 경우 작업 완료시 cnt가 되므로)
        for (int i = cnt; i >= 0; i--) {
            int future = i + time[i]; // future가 범위 내에 있을 때 비용을 더해줘야 한다.
            if (future <= cnt) {
                answer = Math.max(answer, money[i] + dp[future]);
            }
            dp[i] = answer;
        }
    }

    static void bottom_up() {
        answer = 0;
        for (int i = 0; i <= cnt; i++) {
            answer = Math.max(answer, dp[i]);
            int future = i + time[i]; // future가 범위 내에 있을 때 비용을 더해줘야 한다.
            if (future <= cnt) {
                dp[future] = Math.max(dp[future], answer + money[i]);
            }
        }
    }
}
