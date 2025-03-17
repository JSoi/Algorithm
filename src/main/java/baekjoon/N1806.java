package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * <a href ="https://www.acmicpc.net/problem/1806">부분합</a>
 */
public class N1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tok = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(tok.nextToken());
        int S = Integer.parseInt(tok.nextToken());
        tok = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(tok.nextToken());
        }
        int left = 0, sum = 0, minLength = Integer.MAX_VALUE;
        for (int right = 0; right < arr.length; right++) {
            sum += arr[right];
            while (sum >= S) {
                minLength = Math.min(minLength, right - left + 1);
                sum -= arr[left++];
            }
        }
        System.out.println(minLength == Integer.MAX_VALUE ? 0 : minLength);
    }
}
