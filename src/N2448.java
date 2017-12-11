import java.util.Scanner;

public class N2448 {
	static char[][] arr;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int lineInput = scan.nextInt();
		arr = new char[3072][6143];
		init(lineInput);
		printstar(0, lineInput - 1, lineInput);
		printAll(lineInput);
		scan.close();
	}

	public static void init(int lineInput) {
		int i, j;
		for (i = 0; i < lineInput; i++) {
			j = 0;
			for (; j < lineInput - i - 1; j++) {
				arr[i][j] = ' ';
			}
			for (; j < lineInput + i; j++) {
				arr[i][j] = '*';

			}
		}

	}

	public static void printvoid(int x, int y, int n) {
		int k = 2 * n - 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < k; j++) {
				arr[x + i][y + i + j] = ' ';
			}
			k -= 2;
		}
	}

	public static void printstar(int x, int y, int n) {
		if (n == 1)
			return;
		int m = n / 2;
		printstar(x, y, m);
		printstar(x + m, y - m, m);
		printstar(x + m, y + m, m);
		printvoid(x + m, y - m + 1, m);
	}

	public static void printAll(int line) {
		StringBuilder stb = new StringBuilder();
		for (int i = 0; i < line; i++) {
			for (int j = 0; j <  2 * line - 1; j++) {
				if(arr[i][j] == '\0') {
					stb.append(' ');
				}
				else {
					stb.append(arr[i][j]);					
				}
			}
			stb.append("\n");
		}
		System.out.print(stb.toString());
	}

}
