package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N1080 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int rCount = Integer.parseInt(line.split(" ")[0]);
        int cCount = Integer.parseInt(line.split(" ")[1]);
        boolean[][] a = getArr(br, rCount, cCount);
        boolean[][] b = getArr(br, rCount, cCount);
        if (rCount < 3 || cCount < 3) {
            System.out.println(isSame(a, b, a.length - 1, a[0].length - 1) ? 0 : -1);
            return;
        }
        int answer = 0;
        for (int r = 0; r < rCount - 2; r++) {
            for (int c = 0; c < cCount - 2; c++) {
                if (a[r][c] == b[r][c]) {
                    continue;
                }
                flip(a, r, c);
                answer++;
            }
        }
        boolean isSame = isSame(a, b, a.length - 1, a[0].length - 1);
        System.out.println(isSame ? answer : -1);
    }

    private static boolean[][] getArr(BufferedReader br, int rCount, int cCount) throws IOException {
        boolean[][] array = new boolean[rCount][cCount];
        for (int i = 0; i < rCount; i++) {
            String subLine = br.readLine();
            array[i] = new boolean[cCount];
            for (int j = 0; j < cCount; j++) {
                array[i][j] = subLine.charAt(j) == '1';
            }
        }
        return array;
    }

    static boolean isSame(boolean[][] a, boolean[][] b, int toR, int toC) {
        for (int r = 0; r <= toR; r++) {
            for (int c = 0; c <= toC; c++) {
                if (a[r][c] != b[r][c]) {
                    return false;
                }
            }
        }
        return true;
    }

    static void flip(boolean[][] changeArr, int targetR, int targetC) {
        for (int r = targetR; r <= targetR + 2; r++) {
            for (int c = targetC; c <= targetC + 2; c++) {
                changeArr[r][c] = !changeArr[r][c];
            }
        }
    }
}
