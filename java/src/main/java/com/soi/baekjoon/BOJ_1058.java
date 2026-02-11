package com.soi.baekjoon;


import java.util.Scanner;

public class BOJ_1058 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = Integer.parseInt(scan.nextLine());
        boolean[][] friendShip = new boolean[N][N];
        for (int r = 0; r < N; r++) {
            String line = scan.nextLine();
            for (int c = 0; c < N; c++) {
                friendShip[r][c] = line.charAt(c) == 'Y';
            }
        }
//        Arrays.stream(friendShip).map(Arrays::toString).forEach(System.out::println);
        boolean[][] friendShipBetween = new boolean[N][N];
        for (int bet = 0; bet < N; bet++) {
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (r == c) continue;
                    friendShipBetween[r][c] |= friendShip[r][bet] && friendShip[bet][c];
                }
            }
        }
//        Arrays.stream(friendShipBetween).map(Arrays::toString).forEach(System.out::println);
        int answer = 0;
        for (int r = 0; r < N; r++) {
            int NfriendSum = 0;
            for (int c = 0; c < N; c++) {
                NfriendSum += friendShip[r][c] || friendShipBetween[r][c] ? 1 : 0;
            }
            answer = Math.max(answer, NfriendSum);
        }
        System.out.println(answer);
    }
}
