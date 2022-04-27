package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//가장 긴 증가하는 부분 수열
public class N11053 {

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(buf.readLine());
        StringTokenizer tok = new StringTokenizer(buf.readLine());
        int[] arr = new int[cnt];
        int[] dp = new int[cnt];
        for (int i = 0; i < cnt; i++) {
            arr[i] = Integer.parseInt(tok.nextToken());
        }
        Arrays.fill(dp,1);
        for (int i = 1; i < cnt; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }
        int max = Arrays.stream(dp).max().getAsInt();
        System.out.println(max);
    }
}
