package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N1074 {
    static int answer;
    static int[][] map;
    static int r, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int N = (int) Math.pow(2, Integer.parseInt(line[0]));
        r = Integer.parseInt(line[1]);
        c = Integer.parseInt(line[2]);
        map = new int[N][N];
        travel(N, 0, 0);
        System.out.println(map[r][c]);
    }

    private static void travel(int n, int startR, int startC) {
        if (n == 2) {
            map[startR][startC] = answer;
            map[startR][startC + 1] = answer + 1;
            map[startR + 1][startC] = answer + 2;
            map[startR + 1][startC + 1] = answer + 3;
            answer += 4;
            return;
        }
        int offset = n / 2;
        travel(offset, startR, startC);
        travel(offset, startR, startC + offset);
        travel(offset, startR + offset, startC);
        travel(offset, startR + offset, startC + offset);
    }
}
