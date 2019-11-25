package baekjoon;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class N10989 {
	/*
	 * 첫째 줄에 수의 개수 N(1 ≤ N ≤ 10,000,000)이 주어진다. 둘째 줄부터 N개의 줄에는 숫자가 주어진다. 이 수는
	 * 10,000보다 작거나 같은 자연수이다. 첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int counting[] = new int[10001];
		int givenNumbers = scan.nextInt();
		int max = 0;
		for (int i = 0; i < givenNumbers; i++) {
			int put = scan.nextInt();
			if (max <= put) {
				max = put;
			}
			counting[put]++;
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 1; i <= max; i++) {
			for (int k = 0; k < counting[i]; k++) {
				bw.write(i + "\n");
			}
		}
		bw.flush();
		scan.close();
	}
}
