package baekjoon;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class N10989 {
	/*
	 * ù° �ٿ� ���� ���� N(1 �� N �� 10,000,000)�� �־�����. ��° �ٺ��� N���� �ٿ��� ���ڰ� �־�����. �� ����
	 * 10,000���� �۰ų� ���� �ڿ����̴�. ù° �ٺ��� N���� �ٿ� ������������ ������ ����� �� �ٿ� �ϳ��� ����Ѵ�.
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
