package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N1072 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] cntArr = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        long totalGameCount = cntArr[0];
        long winCount = cntArr[1];
        int winRate = getWinRate(winCount, cntArr[0]);
        int answer = -1;
        if (winRate >= 99) {
            System.out.println(answer);
            return;
        }
        long startWinCount = 1;
        long endWinCount = totalGameCount;
        int startWinRate = winRate;
        int endWinRate = 100;
        while (startWinRate < endWinRate && endWinCount != startWinCount) {
            long midWinCount = (startWinCount + endWinCount) / 2;
            int midWinRate = getWinRate((winCount + midWinCount), (totalGameCount + midWinCount));
            if (midWinRate > winRate) {
                endWinCount = midWinCount;
                endWinRate = midWinRate;
            } else {
                startWinCount = midWinCount + 1;
                startWinRate = getWinRate(winCount + startWinCount, totalGameCount + startWinCount);
            }
        }
        System.out.println(startWinCount);
        br.close();
    }

    private static int getWinRate(long winCount, long totalGameCount) {
        return (int) ((winCount * 100) / totalGameCount);
    }
}
