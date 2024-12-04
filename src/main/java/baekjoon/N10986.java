package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N10986 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tok = new StringTokenizer(buf.readLine());
		int n = Integer.parseInt(tok.nextToken());
		int m = Integer.parseInt(tok.nextToken());
		long[] arr = new long[n];
		long[] rem = new long[m];
		long answer = 0;
		tok = new StringTokenizer(buf.readLine());
		arr[0] = Integer.parseInt(tok.nextToken());
		for (int i = 1; i < n; i++) {
			arr[i] = Integer.parseInt(tok.nextToken()) + arr[i - 1];
		}
		for (int i = 0; i < n; i++) {
			int re = (int) (arr[i] % m);
			if (re == 0)
				answer++;
			rem[re]++;
		}
		for (int i = 0; i < m; i++) {
			if (rem[i] > 1) {
				answer = answer + (rem[i] * (rem[i] - 1) / 2);
			}
		}
		System.out.println(answer);
	}

}
