package baekjoon;
import java.util.Scanner;
import java.util.StringTokenizer;

public class N1152_2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		StringTokenizer st = new StringTokenizer(input," ");
		int count = 0;
		while (st.hasMoreTokens()) {
			st.nextToken();
			count++;
		}
		System.out.println(count);
		scan.close();
	}
}
