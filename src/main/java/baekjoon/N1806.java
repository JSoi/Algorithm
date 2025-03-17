package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tok = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(tok.nextToken());
        int S = Integer.parseInt(tok.nextToken());
        int answer = N + 1;
        tok = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[N];
        long[] sum = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(tok.nextToken());
        }
        sum[0] = arr[0];
        for (int i = 1; i < N; i++) {
            sum[i] += sum[i - 1] + arr[i];
            if (sum[i] == S) {
                answer = Math.min(answer, i + 1);
                continue;
            }
            if (sum[i] > S) {
                for (int start = i - 1; start >= Math.max(0, i - answer); start--) {
                    if (sum[i] - sum[start] >= S) {
                        answer = Math.min(answer, i - start);
                        break;
                    }
                }
            }
        }
        System.out.println(answer == N+1? 0 : answer);
    }
}
