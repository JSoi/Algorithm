package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class N17298 {
	static StringBuffer sb = new StringBuffer();
	static int[] arr;
	static int[] result;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		int cnt = Integer.parseInt(buf.readLine());
		arr = new int[cnt];
		result = new int[cnt];
		StringTokenizer tok = new StringTokenizer(buf.readLine());
		for (int i = 0; i < cnt; i++) {
			arr[i] = Integer.parseInt(tok.nextToken());
		}
//		for (int i = 0; i < cnt; i++) {
//			oh(i);
//		}
		Stack<Integer> st = new Stack<Integer>();
		st.push(0);
		for(int i = 1; i < cnt; i++) {
			
		}
		Arrays.stream(result).forEach(e -> System.out.print(e + " "));
	}

	static void go(int index) {

	}

	static void oh(int index) {
		if (index == arr.length - 1) {
			result[index] = -1;
			return;
		}
		for (int i = index; i < arr.length; i++) {
			if (arr[index] < arr[i]) {
				result[index] = arr[i];
				return;
			}
		}
		result[index] = -1;
	}
}
