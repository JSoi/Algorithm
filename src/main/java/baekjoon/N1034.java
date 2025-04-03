package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N1034 {
    private static int row;
    private static int col;
    private static boolean[] lightStatus;
    private static boolean[] onRow;
    private static int answer;
    private static int k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        row = Integer.parseInt(line[0]);
        col = Integer.parseInt(line[1]);
        lightStatus = new boolean[row * col];
        onRow = new boolean[row];
        Arrays.fill(onRow, true);
        for (int r = 0; r < row; r++) {
            String l = br.readLine();
            for (int c = 0; c < col; c++) {
                lightStatus[r * col + c] = l.charAt(c) == '1';
            }
        }

        for (int c = 0; c < col; c++) {
            for (int r = 0; r < row; r++) {
                if (!lightStatus[r * col + c]) {
                    onRow[r] = false;
                    break;
                }
            }
        }

        k = Integer.parseInt(br.readLine()) % ((int) Math.pow(2, col));
        findSuitableCol(0);
        System.out.println(answer);
    }

    private static void findSuitableCol(int count) {
        if (count == k) {
            int onRowCount = findOnRowCount();
            answer = Math.max(onRowCount, answer);
            return;
        }
        for (int i = 0; i < col; i++) {
            boolean[] temp = Arrays.copyOf(lightStatus, lightStatus.length);
            changeColumnStatus(i);
            findSuitableCol(count + 1);
            lightStatus = temp;
        }
    }

    private static int findOnRowCount() {
        int count = 0;
        for (int r = 0; r < row; r++) {
            int c;
            for (c = 0; c < col; c++) {
                if (!lightStatus[r * col + c]) {
                    break;
                }
            }
            if (c == col) {
                count++;
            }
        }
        return count;
    }

    private static void changeColumnStatus(int c) {
        for (int r = 0; r < row; r++) {
            lightStatus[r * col + c] = !lightStatus[r * col + c];
        }
    }
}
