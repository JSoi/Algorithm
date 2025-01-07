package baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.TreeMap;

public class N1275 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int turnCount = Integer.parseInt(br.readLine().split(" ")[1]);
        long[] arr = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        long[] sumArr = new long[arr.length];
        sumArr[0] = arr[0];
        for (int i = 1; i < sumArr.length; i++) {
            sumArr[i] = sumArr[i - 1] + arr[i];
        }
        TreeMap<Integer, Long> offsetTree = new TreeMap<>();
        for (int i = 0; i < turnCount; i++) {
            long[] lineInput = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
            int start = (int) Math.min(lineInput[0] - 1, lineInput[1] - 1);
            int end = (int) Math.max(lineInput[0] - 1, lineInput[1] - 1);
            int changeIdx = (int) (lineInput[2] - 1);
            long changeValue = lineInput[3];
            long offset = offsetTree.headMap(changeIdx).values().stream().reduce(0L, Long::sum);
            bw.append(String.valueOf((sumArr[end] - (start <= 0 ? 0 : sumArr[start - 1])) + offset)).append("\n");
            offsetTree.put(changeIdx, offsetTree.getOrDefault(changeIdx, 0L) + changeValue - arr[changeIdx]);
            arr[changeIdx] = changeValue;
        }
        bw.flush();
        bw.close();
        br.close();

    }
}
