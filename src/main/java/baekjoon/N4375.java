package baekjoon;

import java.util.*;
import java.io.*;

public class N4375 {
	// 2와 5로 나누어 떨어지지 않는 정수 n(1 ≤ n ≤ 10000)가 주어졌을 때, 1로만 이루어진 n의 배수를 찾는 프로그램을
	// 작성하시오.
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = null;
		int len = 0;
		while ((str = buf.readLine())!= null) {
			int n = Integer.parseInt(str);
			long val = 1;
			len=1;
			while(true) {
				if(val%n==0) {
					break;
				}
				val = (val*10)+1;
				len++;
			}
			sb.append(len+"\n");
		}
		System.out.println(sb.toString());
	}

}
