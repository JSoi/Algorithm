package baekjoon;
import java.util.Scanner;

public class N1152 {
	public static void main(String[] args) {
		String[] dictionary = new String[1000000];
		String rawInput[];
		int[] dicValue = new int[1000000];
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		rawInput = input.split(" ");
		for (int i = 0; i < rawInput.length; i++) {
			String s = rawInput[i];
			updateCount(s, dictionary, dicValue);
		}
		System.out.println(giveLength(dicValue));
		scan.close();
	}

	public static void updateCount(String input, String[] dic, int[] dicV) {
		String downCase = input.toLowerCase();
		checkString(downCase, dic, dicV);
	}

	public static void checkString(String input, String[] dic, int[] dicV) {
		int i;
		int check = giveLength(dicV);
		for (i = 0; i < check; i++) {
			if (dic[i].equals(input)) {
				dicV[i]++;
				break;
			}
		}
		if (i == check) {
			dic[i] = input;
			dicV[i] = 1;
		}
	}

	public static int giveLength(int[] dicV) {
		int result = 0;
		for (;;) {
			if (dicV[result] == 0) {
				return result;
			}
			result++;
		}
	}
}
