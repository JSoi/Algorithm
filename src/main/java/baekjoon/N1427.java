package baekjoon;
import java.util.Arrays;
import java.util.Scanner;

public class N1427 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.next();
		scan.close();
		char charValue[] = input.toCharArray();
		Arrays.sort(charValue);
		for(int i = charValue.length-1; i >=0; i--) {
			System.out.print(charValue[i]);
		}
	}
}
