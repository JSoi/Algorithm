package baekjoon;

import java.util.Scanner;

public class N1285 {

    static int[][] fCount;
    static boolean[][] isFront;
    static int n;
    static boolean[][] flipped;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = Integer.parseInt(sc.nextLine());
        fCount = new int[n][2];
        flipped = new boolean[n][2];
        isFront = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            char[] charArray = sc.nextLine().toCharArray();
            for (int j = 0; j < charArray.length; j++) {
                char c = charArray[j];
                if (c == 'T') { // 윗면
                    fCount[i][0]++;
                    fCount[j][1]++;
                    isFront[i][j] = true;
                }
            }
        }
        int answer = sum();
        while (!allVisited()) {
            int[] min = findMin();
            if (min == null || flipped[min[1]][min[0] == 0 ? 0 : 1]) {
                break;
            }
            flip(min[1], min[0] == 0);
            flipped[min[1]][min[0] == 0 ? 0 : 1] = true;
            answer = Math.min(answer, sum());
        }
        System.out.println(answer);

    }

    static boolean allVisited() {
        for (boolean[] f : flipped) {
            for (boolean b : f) {
                if (!b) {
                    return false;
                }
            }
        }
        return true;
    }

    static int[] findMin() {
        boolean isRow = false;
        int idx = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (flipped[i][0]) {
                continue;
            }
            if (min > fCount[i][0]) {
                isRow = true;
                min = fCount[i][0];
                idx = i;
            }
        }
        for (int j = 0; j < n; j++) {
            if (flipped[j][1]) {
                continue;
            }
            if (min > fCount[j][1]) {
                isRow = false;
                min = fCount[j][1];
                idx = j;
            }

        }
        if (min == Integer.MAX_VALUE) {
            return null;
        }
        return new int[]{isRow ? 0 : 1, idx};
    }

    static int sum() {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += fCount[i][1];
        }
        return sum;
    }

    static void flip(int target, boolean isRow) {
        if (isRow) {
            for (int i = 0; i < n; i++) {
                isFront[target][i] = !isFront[target][i];
                if (!isFront[target][i]) {
                    fCount[target][0] = n - fCount[target][0];
                    fCount[i][1] = n - fCount[i][1];
                }
            }
        } else {
            for (int i = 0; i < n; i++) {
                isFront[i][target] = !isFront[i][target];
                if (!isFront[i][target]) {
                    fCount[target][1] = n - fCount[target][1];
                    fCount[i][0] = n - fCount[i][0];
                }
            }
        }
    }

}
