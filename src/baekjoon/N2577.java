package baekjoon;
import java.util.Scanner;

public class N2577 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int count[] = new int[10];
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();
		int result = a * b * c;
		int mine = result;
		while (mine != 0) {
			int k = mine % 10;
			count[k]++;
			mine /= 10;
		}
		for (int i = 0; i < 10; i++) {
			System.out.println(count[i]);
		}
		scan.close();

	}
}
