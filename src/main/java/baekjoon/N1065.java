package baekjoon;
import java.util.Scanner;

public class N1065 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int origin = scan.nextInt();
		int count = 0;
		for (int i = 1; i <= origin; i++) {
			if(hans(i)) {
				count++;
			}
		}
		scan.close();
		System.out.println(count);
	}
	public static boolean hans(int input) {
		boolean question = false;
		if(input == 1000) {
			return false;
		}
		char[] chars = ("" + input).toCharArray();
		if(chars.length == 3) {
			if((int)chars[2] - (int)chars[1] == (int)chars[1] - (int)chars[0]) {
				question = true;
			}
		}
		else {
			question = true;
		}
		return question;
	}
}
