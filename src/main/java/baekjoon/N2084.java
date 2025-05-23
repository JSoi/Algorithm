package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class N2084 {
    static int n;
    static int[] arr;
    static boolean[][] answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = Integer.parseInt(sc.nextLine());
        arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        boolean[][] conn = new boolean[n][n];
        backTracking(0, conn);
        if (answer == null) {
            System.out.println(-1);
        } else {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print((answer[i][j] ? "1" : "0") + " ");
                }
                System.out.println();
            }
        }
    }

    private static void backTracking(int i, boolean[][] conn) {
        if (answer != null) return;
        if (Arrays.stream(arr).sum() == 0) {
            answer = new boolean[n][n];
            for (int j = 0; j < n; j++) {
                answer[j] = Arrays.copyOf(conn[j], n);
            }
            return;
        }
        for (int j = 0; j < n; j++) {
            if (i == j || arr[i] == 0 || arr[j] == 0 || conn[i][j] || conn[j][i]) {
                continue;
            }
            conn[i][j] = conn[j][i] = true;
            arr[i] -= 1;
            arr[j] -= 1;
            backTracking(j, conn);
            arr[i] += 1;
            arr[j] += 1;
            conn[i][j] = conn[j][i] = false;
        }
    }
}
