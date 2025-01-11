package baekjoon;

import java.io.*;
import java.util.Arrays;

public class N1099 {
    private static final int MAX = Integer.MAX_VALUE;
    static String[] candidates;
    static String[] sortedCandidates;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String sentence = br.readLine();
        int count = Integer.parseInt(br.readLine());
        candidates = new String[count];
        for (int lc = 0; lc < count; lc++) {
            candidates[lc] = br.readLine();
        }
        dp = new int[sentence.length()];
        Arrays.fill(dp, MAX);
        sortedCandidates =
                Arrays.stream(candidates).map(a -> getAscStr(a)).toArray(String[]::new);
        bw.append(String.valueOf(findMinChangeCount(sentence)));
        bw.flush();
        br.close();
        bw.close();
    }

    static int findMinChangeCount(String input) {
        for (int i = 0; i < dp.length; i++) {
            dp[i] = findCandidateValue(input.substring(0, i + 1));
            for (int j = 0; j < i; j++) {
                if (dp[j] == MAX) {
                    continue;
                }
                String compare = input.substring(j + 1, i + 1);
                int subCandidateValue = findCandidateValue(compare);
                if (subCandidateValue != MAX) {
                    dp[i] = Math.min(dp[i], dp[j] + subCandidateValue);
                }
            }
        }
        return dp[dp.length - 1] == MAX ? -1 : dp[dp.length - 1];
    }

    static String getAscStr(String input) {
        char[] charArray = input.toCharArray();
        Arrays.sort(charArray);
        return String.valueOf(charArray);
    }

    static int differenceBetweenStr(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            diff += (a.charAt(i) != b.charAt(i) ? 1 : 0);
        }
        return diff;
    }

    // 주어진 단어 리스트 중 사용 가능한지, 사용 가능하다면 최소 비용을 반환하는 함수
    // 사용 가능한 단어가 없다면 최대값을 리턴
    static int findCandidateValue(String compare) {
        String sortedCompare = getAscStr(compare);
        int minCandidateValue = MAX;
        for (int k = 0; k < sortedCandidates.length; k++) {
            if (sortedCandidates[k].equals(sortedCompare)) {
                minCandidateValue = Math.min(minCandidateValue, differenceBetweenStr(candidates[k], compare));
            }
        }
        return minCandidateValue;
    }
}
