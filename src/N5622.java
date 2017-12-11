import java.util.Scanner;

public class N5622 {

	public static void main(String[] args) {
		int[] time = { 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 7, 8, 8, 8, 9, 9, 9, 9 };
		Scanner scan = new Scanner(System.in);
		String input = scan.next();
		char[] inputChunk = input.toCharArray();
		int timeCount = 0;
		for (int i = 0; i < inputChunk.length; i++) {
			timeCount += time[inputChunk[i] - 65] + 1;
		}
		System.out.println(timeCount);
		scan.close();
	}

}
